package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class InnertubePlaylist implements Identifiable, Visual {

    @NotNull
    String id;

    @NotNull
    String name;

    @Nullable
    String description;

    @NotNull
    @Unmodifiable
    List<Thumbnails.Thumbnail> thumbnails;

    @NotNull
    @Unmodifiable
    List<Continuation> continuations;

    @NotNull
    @Unmodifiable
    List<InnertubeSong> songs;

    @Nullable
    String songContinuation;

    public InnertubePlaylist( @NotNull MusicTwoRowItemRenderer renderer ) {
        Runs.Run run = Objects.requireNonNull(
                renderer.getTitle()
                        .getRuns()
                        .getFirst()
        );

        this.id = Objects.requireNonNull(
                run.getNavigationEndpoint()
                   .getBrowseEndpoint()
                   .getBrowseId()
        );
        this.name = run.getText();
        this.description = null;
        this.thumbnails = ItemUtils.extractThumbnail( renderer.getThumbnailRenderer() );
        this.continuations = Collections.emptyList();
        this.songs = Collections.emptyList();
        this.songContinuation = null;
    }

    public InnertubePlaylist( BrowseResponse.Contents.@NotNull TwoColumnBrowseResultsRenderer renderer ) {
        SectionListRenderer.Content.MusicResponsiveHeaderRenderer headerRenderer =
                Objects.requireNonNull(
                               renderer.getTabs()
                                       .getFirst()
                                       .getTabRenderer()
                                       .getContent()
                                       .getSectionListRenderer()
                       )
                       .getContents()
                       .getFirst()
                       .getMusicResponsiveHeaderRenderer();
        assert headerRenderer != null;
        SectionListRenderer sectionListRenderer = Objects.requireNonNull( renderer.getSecondaryContents() ).getSectionListRenderer();
        MusicPlaylistShelfRenderer playlistShelfRenderer = sectionListRenderer.getContents()
                                                                              .getFirst()
                                                                              .getMusicPlaylistShelfRenderer();
        assert playlistShelfRenderer != null;

        String playlistId = playlistShelfRenderer.getPlaylistId();
        // Add "VL" in case it's not there
        this.id = playlistId.startsWith( "VL" ) ? playlistId : "VL" + playlistId;
        this.name = ItemUtils.getFirstText( headerRenderer.getTitle() );
        this.description = ItemUtils.getFirstText(
                headerRenderer.getDescription()
                              .getMusicDescriptionShelfRenderer()
                              .getDescription()
        );
        this.thumbnails = ItemUtils.extractThumbnail( headerRenderer.getThumbnail() );
        this.continuations = Collections.unmodifiableList( sectionListRenderer.getContinuations() );
        this.songs = playlistShelfRenderer.getContents()
                                          // [MusicPlaylistShelfRenderer.getCollapsedItemCount] tells how many
                                          // items inside this list are actual song items, the rest are either
                                          // fillers or placeholders.
                                          .subList( 0, playlistShelfRenderer.getCollapsedItemCount() )
                                          .stream()
                                          .map( MusicPlaylistShelfRenderer.Content::getMusicResponsiveListItemRenderer )
                                          // Filter out null values
                                          .flatMap( v -> v == null ? Stream.empty() : Stream.of( v ) )
                                          .map( InnertubeSong::new )
                                          .collect( Collectors.toUnmodifiableList() );

        // When a playlist with 100+ songs, YT only returns first 100 songs
        // with 101st item being the continuation string.
        MusicPlaylistShelfRenderer.Content.ContinuationItemRenderer continuationItemRenderer = playlistShelfRenderer.getContents()
                                                                                                                    .getLast()
                                                                                                                    .getContinuationItemRenderer();
        this.songContinuation = continuationItemRenderer == null
                ? null
                : continuationItemRenderer.getContinuationEndpoint()
                                          .getContinuationCommand(

                                          ).getToken();
    }
}
