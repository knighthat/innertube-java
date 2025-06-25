package me.knighthat.innertube.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Value
public class InnertubePlaylist extends InnertubeItem {

// START: Static fields/functions
    public static @NotNull InnertubePlaylist from( @NotNull MusicTwoRowItemRenderer renderer ) {
        return new InnertubePlaylist( renderer, null, Collections.emptyList(), Collections.emptyList(), null, null );
    }

    public static @NotNull InnertubePlaylist from(
            @NotNull String visitorData,
            BrowseResponse.Contents.@NotNull TwoColumnBrowseResultsRenderer renderer
    ) {
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
        ContinuedPlaylist continuedPlaylist = ContinuedPlaylist.from( playlistShelfRenderer.getContents() );

        return new InnertubePlaylist(
                // Add "VL" in case it's not there
                playlistId.startsWith( "VL" ) ? playlistId : "VL" + playlistId,
                ItemUtils.getFirstText( headerRenderer.getTitle() ),
                ItemUtils.extractThumbnail( headerRenderer.getThumbnail() ),
                ItemUtils.getFirstText(
                        headerRenderer.getDescription()
                                      .getMusicDescriptionShelfRenderer()
                                      .getDescription()
                ),
                sectionListRenderer.getContinuations(),
                continuedPlaylist.getSongs(),
                continuedPlaylist.getContinuation(),
                visitorData
        );
    }
// END: Static fields/functions

    @Nullable
    String description;

    @NotNull
    @Unmodifiable
    List<Continuation> continuations;

    @NotNull
    @Unmodifiable
    List<InnertubeSong> songs;

    @Nullable
    String songContinuation;

    @Nullable
    String visitorData;

    public InnertubePlaylist(
            @NotNull String id,
            @NotNull String name,
            @NotNull List<? extends Thumbnails.Thumbnail> thumbnails,
            @Nullable String description,
            @NotNull List<? extends Continuation> continuations,
            @NotNull List<InnertubeSong> songs,
            @Nullable String songContinuation,
            @Nullable String visitorData
    ) {
        super( id, name, thumbnails );
        this.description = description;
        this.continuations = Collections.unmodifiableList( continuations );
        this.songs = Collections.unmodifiableList( songs );
        this.songContinuation = songContinuation;
        this.visitorData = visitorData;
    }

    public InnertubePlaylist(
            @NotNull MusicTwoRowItemRenderer renderer,
            @Nullable String description,
            @NotNull List<? extends Continuation> continuations,
            @NotNull List<InnertubeSong> songs,
            @Nullable String songContinuation,
            @Nullable String visitorData
    ) {
        super( renderer );
        this.description = description;
        this.continuations = Collections.unmodifiableList( continuations );
        this.songs = Collections.unmodifiableList( songs );
        this.songContinuation = songContinuation;
        this.visitorData = visitorData;
    }

    public @NotNull String getBrowseId() {
        return id.startsWith( "VL" ) ? id : "VL" + id;
    }
}
