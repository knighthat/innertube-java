package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Objects;

@Value
public class InnertubeAlbum implements Identifiable, Visual {

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
// END: Static fields/functions

    @NotNull
    String id;

    @NotNull
    String name;

    @NotNull
    @Unmodifiable
    List<Thumbnails.Thumbnail> thumbnails;

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

    public InnertubeAlbum( @NotNull MusicTwoRowItemRenderer renderer ) {
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
        this.thumbnails = ItemUtils.extractThumbnail( renderer.getThumbnailRenderer() );
        List<Endpoint.Browse> artistsAndAlbum = ItemUtils.extractArtistsAndAlbum( renderer.getSubtitle()
                                                                                          .getRuns() );
        this.artists = artistsAndAlbum.subList( 1, artistsAndAlbum.size() );
        this.year = extractYear( renderer.getSubtitle()
                                         .getRuns() );
        this.explicit = ItemUtils.containsExplicitBadge( renderer.getSubtitleBadges() );
    }

    public InnertubeAlbum( @NotNull MusicResponsiveListItemRenderer renderer ) {
        List<? extends MusicResponsiveListItemRenderer.Colum> columns = renderer.getFlexColumns();
        // Requires at least 2 columns, 1 for title, and 1 for artist(s) (and maybe release year)
        assert columns.size() >= 2;

        Runs title = Objects.requireNonNull(
                                    columns.getFirst()
                                           .getMusicResponsiveListItemFlexColumnRenderer()
                            )
                            .getText();
        assert title != null;
        Runs artists = Objects.requireNonNull(
                                      columns.get( 1 )
                                             .getMusicResponsiveListItemFlexColumnRenderer()
                              )
                              .getText();
        assert artists != null;

        this.id = Objects.requireNonNull(
                                 renderer.getNavigationEndpoint()
                                         .getBrowseEndpoint()
                         )
                         .getBrowseId();
        this.name = ItemUtils.getFirstText( title );
        this.thumbnails = ItemUtils.extractThumbnail( renderer.getThumbnail() );
        this.artists = ItemUtils.extractArtistsAndAlbum( artists.getRuns() );
        this.year = extractYear( artists.getRuns() );
        this.explicit = ItemUtils.containsExplicitBadge( renderer.getBadges() );
    }
}
