package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
public class InnertubeSong implements Identifiable, Visual {

// START: Static fields/functions
    /**
     * Matches:
     * - 0:12
     * - 12:23
     * - 1:02:03
     */
    private static final Pattern DURATION_PATTERN = Pattern.compile( "^(?:(\\d+):)?(\\d{1,2}):(\\d{2})$" );

    /**
     * Extract duration text from both columns
     */
    private static @NotNull Optional<String> extractDuration( @NotNull MusicResponsiveListItemRenderer renderer ) {
        return Stream.concat(
                             renderer.getFlexColumns()
                                     .stream()
                                     .map( MusicResponsiveListItemRenderer.Colum::getMusicResponsiveListItemFlexColumnRenderer ),
                             renderer.getFixedColumns()
                                     .stream()
                                     .map( MusicResponsiveListItemRenderer.Colum::getMusicResponsiveListItemFixedColumnRenderer )
                     )
                     .flatMap( colRenderer -> {
                         if ( colRenderer == null || colRenderer.getText() == null )
                             return Stream.empty();

                         return colRenderer.getText()
                                           .getRuns()
                                           .stream();
                     } )
                     .map( Runs.Run::getText )
                     .filter( text -> DURATION_PATTERN.matcher( text )
                                                      .matches() )
                     .findFirst();
    }
// END: Static fields/functions

    @NotNull
    String id;

    @NotNull
    String name;

    /**
     * Contains videoId and possibly params
     */
    @NotNull
    Endpoint.Watch watchEndpoint;

    @NotNull
    @Unmodifiable
    List<Thumbnails.Thumbnail> thumbnails;

    /**
     * Plain text representation of duration, in short format
     */
    @NotNull
    String durationText;

    /**
     * Whether song is appropriate for all listeners
     */
    boolean explicit;

    /**
     * Contains information about this song's album
     */
    @Nullable
    Endpoint.Browse album;

    /**
     * List of artists featured in this song
     */
    @NotNull
    List<Endpoint.Browse> authors;

    /**
     * All authors listed in 1 line, with delimiter in between
     */
    @NotNull
    String authorsText;

    public InnertubeSong( PlaylistPanelRenderer.Content.@NotNull VideoRenderer renderer ) {
        Deque<Endpoint.Browse> artistsAndAlbum = ItemUtils.extractArtistsAndAlbum( renderer.getLongBylineText()
                                                                                           .getRuns() );

        this.id = renderer.getVideoId();
        this.name = ItemUtils.getFirstText( renderer.getTitle() );
        this.watchEndpoint = Objects.requireNonNull(
                renderer.getNavigationEndpoint()
                        .getWatchEndpoint()
        );
        this.thumbnails = Collections.unmodifiableList(
                renderer.getThumbnail()
                        .getThumbnails()
        );
        this.durationText = ItemUtils.getFirstText( renderer.getLengthText() );
        this.explicit = ItemUtils.containsExplicitBadge( renderer.getBadges() );
        this.album = artistsAndAlbum.pop();
        this.authors = new ArrayList<>( artistsAndAlbum );
        this.authorsText = ItemUtils.getFirstText( renderer.getShortBylineText() );
    }

    public InnertubeSong( @NotNull MusicResponsiveListItemRenderer renderer ) {
        Runs.Run titleRun = null;
        List<Runs.Run> runs = new ArrayList<>( renderer.getFlexColumns()
                                                       .size() );
        for ( MusicResponsiveListItemRenderer.Colum colum : renderer.getFlexColumns() ) {
            // Only MusicResponsiveListItemFlexColumnRenderer contains song's information
            List<? extends Runs.Run> colRuns = colum.getMusicResponsiveListItemFlexColumnRenderer()
                                                    .getText()
                                                    .getRuns();
            if ( colRuns == null || colRuns.isEmpty() )
                continue;

            for ( Runs.Run run : colRuns )
                if ( run.getNavigationEndpoint() != null && run.getNavigationEndpoint()
                                                               .getWatchEndpoint() != null )
                    titleRun = run;

            runs.addAll(
                    colRuns
            );
        }

        assert titleRun != null;
        assert !runs.isEmpty();

        Deque<Endpoint.Browse> artistsAndAlbum = ItemUtils.extractArtistsAndAlbum( runs );

        this.id = titleRun.getNavigationEndpoint()
                          .getWatchEndpoint()
                          .getVideoId();
        this.name = titleRun.getText();
        this.watchEndpoint = titleRun.getNavigationEndpoint()
                                     .getWatchEndpoint();
        this.thumbnails = ItemUtils.extractThumbnail( renderer.getThumbnail() );
        this.durationText = extractDuration( renderer ).orElse( "" );
        this.explicit = ItemUtils.containsExplicitBadge( renderer.getBadges() );
        this.album = artistsAndAlbum.pop();
        this.authors = new ArrayList<>( artistsAndAlbum );
        this.authorsText = runs.stream()            // Payload doesn't contain it, this method is used to get all endpoints and join it to a complete string
                               .filter( run -> {
                                   try {
                                       Endpoint.Browse endpoint = run.getNavigationEndpoint()
                                                                     .getBrowseEndpoint();
                                       return artistsAndAlbum.contains( endpoint );
                                   } catch ( Exception ignored ) {
                                       return false;
                                   }
                               } )
                               .map( Runs.Run::getText )
                               .collect( Collectors.joining( ", " ) );
    }
}
