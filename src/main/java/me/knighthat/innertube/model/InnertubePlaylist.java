package me.knighthat.innertube.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.knighthat.innertube.Constants;
import me.knighthat.innertube.PublicAccessible;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Value
public class InnertubePlaylist extends InnertubeItem implements PublicAccessible {

// START: Static fields/functions
    public static @NotNull InnertubePlaylist from( @NotNull MusicTwoRowItemRenderer renderer ) {
        return new InnertubePlaylist( renderer, null, null, Collections.emptyList(), Collections.emptyList(), null, null );
    }

    public static @NotNull InnertubePlaylist from(
            @NotNull String visitorData,
            BrowseResponse.Contents.@NotNull TwoColumnBrowseResultsRenderer renderer
    ) {
        SectionListRenderer.Content.MusicResponsiveHeaderRenderer headerRenderer =
                Objects.requireNonNull(
                               renderer.getTabs()
                                       .get( 0 )
                                       .getTabRenderer()
                                       .getContent()
                                       .getSectionListRenderer()
                       )
                       .getContents()
                       .get( 0 )
                       .getMusicResponsiveHeaderRenderer();
        assert headerRenderer != null;
        SectionListRenderer sectionListRenderer = Objects.requireNonNull( renderer.getSecondaryContents() ).getSectionListRenderer();
        MusicPlaylistShelfRenderer playlistShelfRenderer = sectionListRenderer.getContents()
                                                                              .get( 0 )
                                                                              .getMusicPlaylistShelfRenderer();
        assert playlistShelfRenderer != null;

        String playlistId = playlistShelfRenderer.getPlaylistId();
        ContinuedPlaylist continuedPlaylist = ContinuedPlaylist.from( playlistShelfRenderer.getContents() );
        String description = null;

        try {
            description = ItemUtils.getFirstText(
                    headerRenderer.getDescription()
                                  .getMusicDescriptionShelfRenderer()
                                  .getDescription()
            );
        } catch ( NullPointerException ignored ) {
        }

        return new InnertubePlaylist(
                // Add "VL" in case it's not there
                playlistId.startsWith( "VL" ) ? playlistId : "VL" + playlistId,
                ItemUtils.getFirstText( headerRenderer.getTitle() ),
                ItemUtils.extractThumbnail( headerRenderer.getThumbnail() ),
                headerRenderer.getSecondSubtitle(),
                description,
                sectionListRenderer.getContinuations(),
                continuedPlaylist.getSongs(),
                continuedPlaylist.getContinuation(),
                visitorData
        );
    }
// END: Static fields/functions

    @Nullable
    Runs subtitle;

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
            @Nullable Runs subtitle,
            @Nullable String description,
            @NotNull List<? extends Continuation> continuations,
            @NotNull List<InnertubeSong> songs,
            @Nullable String songContinuation,
            @Nullable String visitorData
    ) {
        super( id, name, thumbnails );
        this.subtitle = subtitle;
        this.description = description;
        this.continuations = Collections.unmodifiableList( continuations );
        this.songs = Collections.unmodifiableList( songs );
        this.songContinuation = songContinuation;
        this.visitorData = visitorData;
    }

    public InnertubePlaylist(
            @NotNull MusicTwoRowItemRenderer renderer,
            @Nullable Runs subtitle,
            @Nullable String description,
            @NotNull List<? extends Continuation> continuations,
            @NotNull List<InnertubeSong> songs,
            @Nullable String songContinuation,
            @Nullable String visitorData
    ) {
        super( renderer );
        this.subtitle = subtitle;
        this.description = description;
        this.continuations = Collections.unmodifiableList( continuations );
        this.songs = Collections.unmodifiableList( songs );
        this.songContinuation = songContinuation;
        this.visitorData = visitorData;
    }

    public @NotNull String getBrowseId() {
        return id.startsWith( "VL" ) ? id : "VL" + id;
    }

    public @NotNull String getSubtitleText() {
        return this.subtitle == null ? "" : this.subtitle.getRuns().stream().map( Runs.Run::getText ).collect( Collectors.joining() );
    }

    @Override
    public @NotNull String getShareUrl() {
        String playlistId = getBrowseId().startsWith( "VL" )
                ? getBrowseId().replaceFirst( "VL", "" )
                : getBrowseId();
        return Constants.YOUTUBE_URL + "/playlist?list=" + playlistId;
    }

    @Override
    public @NotNull String getYouTubeMusicShareUrl() {
        String playlistId = getBrowseId().startsWith( "VL" )
                ? getBrowseId().replaceFirst( "VL", "" )
                : getBrowseId();
        return Constants.YOUTUBE_MUSIC_URL + "playlist?list=" + playlistId;
    }
}
