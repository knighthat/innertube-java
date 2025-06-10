package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.PageType;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
     * Extract album and artists from provided {@link Runs.Run}.
     * <p>
     * Album or artist is filtered by their respected {@link PageType}.
     * <p>
     * Album's browse will always located at the beginning of the list,
     * if album browse endpoint doesn't exist in {@code runs}, then
     * list will be appended with a null {@code null}.
     * <p>
     * If the list only contains 1 {@code null } element, it means
     * the provided {@code runs} contains neither artists nor album
     *
     * @param runs set of text and navigation endpoints
     *
     * @return album' and artists' browse endpoints in 1 list
     */
    private static @NotNull LinkedList<Endpoint.Browse> extractArtistsAndAlbum( @NotNull List<? extends Runs.Run> runs ) {
        List<Endpoint.Browse> authors = new ArrayList<>();
        Endpoint.Browse album = null;

        for ( Runs.Run run : runs )
            try {
                Endpoint.Browse browseEndpoint = run.getNavigationEndpoint()
                                                    .getBrowseEndpoint();
                String pageType = browseEndpoint.getBrowseEndpointContextSupportedConfigs()
                                                .getBrowseEndpointContextMusicConfig()
                                                .getPageType();

                // TODO Upgrade to REGEX to better results
                switch ( pageType ) {
                    case PageType.ARTIST:
                        authors.add( browseEndpoint );
                        break;
                    case PageType.ALBUM:
                        album = browseEndpoint;
                        break;
                }
            } catch ( NullPointerException ignored ) {
            }

        LinkedList<Endpoint.Browse> results = new LinkedList<>( authors );
        results.addFirst( album );

        // This Deque can't be empty under any circumstances
        assert !results.isEmpty();

        return results;
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
        Deque<Endpoint.Browse> artistsAndAlbum = extractArtistsAndAlbum( renderer.getLongBylineText()
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

        Deque<Endpoint.Browse> artistsAndAlbum = extractArtistsAndAlbum( runs );

        this.id = titleRun.getNavigationEndpoint()
                          .getWatchEndpoint()
                          .getVideoId();
        this.name = titleRun.getText();
        this.watchEndpoint = titleRun.getNavigationEndpoint()
                                     .getWatchEndpoint();
        // Album's songs don't have thumbnail by default,
        // if no thumbnail detected, an empty list will be assigned
        List<Thumbnails.Thumbnail> thumbnails = Collections.emptyList();
        if ( renderer.getThumbnail() != null )
            thumbnails = Collections.unmodifiableList(
                    renderer.getThumbnail()
                            .getMusicThumbnailRenderer()
                            .getThumbnail()
                            .getThumbnails()
            );
        this.thumbnails = thumbnails;
        // Some payload doesn't contain duration, this will look for it
        // and return empty string if it doesn't find anything
        String durationText = "";
        for ( MusicResponsiveListItemRenderer.Colum fixedCol : renderer.getFixedColumns() ) {
            MusicResponsiveListItemRenderer.Colum.Renderer colRenderer = fixedCol.getMusicResponsiveListItemFixedColumnRenderer();
            if ( colRenderer == null || colRenderer.getText() == null )
                continue;

            String text = ItemUtils.getFirstText( colRenderer.getText() );
            if ( DURATION_PATTERN.matcher( text )
                                 .matches() )
                durationText = text;
        }
        this.durationText = durationText;
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
