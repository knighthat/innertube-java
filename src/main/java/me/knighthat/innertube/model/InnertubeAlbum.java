package me.knighthat.innertube.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Value
public class InnertubeAlbum extends InnertubeItem {

// START: Static fields/functions
    private static @NotNull String extractYear( @NotNull List<? extends Runs.Run> runs ) {
        String year = "";
        for ( Runs.Run run : runs )
            if ( run.getText()
                    .matches( "\\d{4}" ) ) {
                year = run.getText();
                break;
            }

        return year;
    }

    public static @NotNull InnertubeAlbum from( @NotNull MusicTwoRowItemRenderer renderer ) {
        List<Endpoint.Browse> artistsAndAlbum = ItemUtils.extractArtistsAndAlbum(
                renderer.getSubtitle().getRuns()
        );

        return new InnertubeAlbum(
                renderer,
                artistsAndAlbum.subList( 1, artistsAndAlbum.size() ),
                extractYear( renderer.getSubtitle().getRuns() ),
                ItemUtils.containsExplicitBadge( renderer.getSubtitleBadges() )
        );
    }

    public static @NotNull InnertubeAlbum from( @NotNull MusicResponsiveListItemRenderer renderer ) {
        List<? extends MusicResponsiveListItemRenderer.Colum> columns = renderer.getFlexColumns();
        // Requires at least 2 columns, 1 for title, and 1 for artist(s) (and maybe release year)
        assert columns.size() >= 2;

        Runs title = Objects.requireNonNull(
                columns.getFirst().getMusicResponsiveListItemFlexColumnRenderer()
        ).getText();
        assert title != null;

        Runs artists = Objects.requireNonNull(
                columns.get( 1 ).getMusicResponsiveListItemFlexColumnRenderer()
        ).getText();
        assert artists != null;

        return new InnertubeAlbum(
                Objects.requireNonNull(
                        renderer.getNavigationEndpoint().getBrowseEndpoint()
                ).getBrowseId(),
                ItemUtils.getFirstText( title ),
                ItemUtils.extractThumbnail( renderer.getThumbnail() ),
                ItemUtils.extractArtistsAndAlbum( artists.getRuns() ),
                extractYear( artists.getRuns() ),
                ItemUtils.containsExplicitBadge( renderer.getBadges() )
        );
    }
// END: Static fields/functions

    /**
     * Artists featured in this album
     */
    @NotNull
    @Unmodifiable
    List<Endpoint.Browse> artists;

    /**
     * The year in which this album was released
     * <p>
     * Returns empty string if unknown
     */
    @NotNull
    String year;

    /**
     * Whether song is appropriate for all listeners
     * <p>
     * Returns {@code false} if unknown
     */
    boolean explicit;

    public InnertubeAlbum(
            @NotNull String id,
            @NotNull String name,
            @NotNull List<? extends Thumbnails.Thumbnail> thumbnails,
            @NotNull @Unmodifiable List<Endpoint.Browse> artists,
            @NotNull String year,
            boolean explicit
    ) {
        super( id, name, thumbnails );
        this.artists = artists;
        this.year = year;
        this.explicit = explicit;
    }

    public InnertubeAlbum(
            @NotNull MusicTwoRowItemRenderer renderer,
            @NotNull @Unmodifiable List<Endpoint.Browse> artists,
            @NotNull String year, boolean explicit
    ) {
        super( renderer );
        this.artists = artists;
        this.year = year;
        this.explicit = explicit;
    }
}
