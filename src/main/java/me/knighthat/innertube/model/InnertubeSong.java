package me.knighthat.innertube.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.knighthat.innertube.PageType;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode(callSuper = true)
@Value
public class InnertubeSong extends InnertubeItem {

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
        return Stream.of (
                             renderer.getFlexColumns()
                                     .stream()
                                     .map( MusicResponsiveListItemRenderer.Colum::getMusicResponsiveListItemFlexColumnRenderer ),
                             renderer.getFixedColumns()
                                     .stream()
                                     .map( MusicResponsiveListItemRenderer.Colum::getMusicResponsiveListItemFixedColumnRenderer )
                     )
                     // Turn Stream<Stream<T>> to Stream<T>
                     .flatMap ( s -> s )
                     .map ( colRenderer -> {
                         if ( colRenderer == null || colRenderer.getText () == null )
                             return null;
                         else
                             return colRenderer.getText ().getRuns ();
                     } )
                     .filter ( Objects::nonNull )
                     .flatMap ( run -> run.stream ().map ( Runs.Run::getText ) )
                     .filter ( text -> DURATION_PATTERN.matcher ( text ).matches () )
                     .findFirst();
    }

    public static @NotNull InnertubeSong from( PlaylistPanelRenderer.Content.@NotNull VideoRenderer renderer ) {
        List<Runs.Run> authors = new ArrayList<> ();
        Runs.Run album = null;

        for ( Runs.Run run : renderer.getLongBylineText ().getRuns () ) {
            Endpoint navEndpoint = run.getNavigationEndpoint ();
            if ( navEndpoint == null || navEndpoint.getBrowseEndpoint () == null )
                continue;

            Endpoint.Browse.Context context = navEndpoint.getBrowseEndpoint ().getBrowseEndpointContextSupportedConfigs ();
            if ( context == null )
                continue;

            switch ( context.getBrowseEndpointContextMusicConfig ().getPageType () ) {
                case PageType.ALBUM -> album = run;
                case PageType.ARTIST -> authors.add ( run );
                default -> {
                }
            }
        }

        return new InnertubeSong(
                renderer.getVideoId(),
                ItemUtils.getFirstText( renderer.getTitle() ),
                renderer.getThumbnail().getThumbnails(),
                ItemUtils.getFirstText( renderer.getLengthText() ),
                ItemUtils.containsExplicitBadge( renderer.getBadges() ),
                album,
                authors,
                ItemUtils.getFirstText( renderer.getShortBylineText() )
        );
    }

    public static @NotNull InnertubeSong from( @NotNull MusicResponsiveListItemRenderer renderer ) {
        String id = null;
        String title = "";
        List<Runs.Run> artists = new ArrayList<> ();
        Runs.Run album = null;

        List<Runs> columns = renderer.getFlexColumns ()
                                     .stream ()
                                     .map ( MusicResponsiveListItemRenderer.Colum::getMusicResponsiveListItemFlexColumnRenderer )
                                     .filter ( Objects::nonNull )
                                     .map ( MusicResponsiveListItemRenderer.Colum.Renderer::getText )
                                     .toList ();

        List<? extends Runs.Run> combined = columns.stream ().flatMap ( col -> col.getRuns ().stream () ).toList ();
        for ( Runs.Run run : combined ) {
            Endpoint navEndpoint = run.getNavigationEndpoint ();
            if ( navEndpoint == null )
                continue;

            if ( navEndpoint.getWatchEndpoint () != null ) {
                title = run.getText ();
                id = navEndpoint.getWatchEndpoint ().getVideoId ();
                continue;
            }

            Endpoint.Browse browse = navEndpoint.getBrowseEndpoint ();
            if ( browse == null || browse.getBrowseEndpointContextSupportedConfigs () == null )
                continue;

            switch ( browse.getBrowseEndpointContextSupportedConfigs ().getBrowseEndpointContextMusicConfig ().getPageType () ) {
                case PageType.ALBUM -> album = run;
                case PageType.ARTIST -> artists.add ( run );
            }
        }

        if ( title.isBlank () ) {
            // Assume first column is song's title
            Runs titleColumn = columns.getFirst ();
            if ( titleColumn != null && !titleColumn.getRuns ().isEmpty () )
                title = ItemUtils.getFirstText ( titleColumn );
        }
        if ( artists.isEmpty () ) {
            // Assume second column is song's artists
            Runs artistsColumn = columns.get ( 1 );
            if ( artistsColumn != null && !artistsColumn.getRuns ().isEmpty () )
                artists.addAll ( artistsColumn.getRuns () );
        }

        // [id] must not be null under any circumstances
        if ( id == null )
            id = Objects.requireNonNull (
                    renderer.getPlaylistItemData ()
            ).getVideoId ();

        return new InnertubeSong(
                id,
                title,
                ItemUtils.extractThumbnail( renderer.getThumbnail() ),
                extractDuration( renderer ).orElse( "" ),
                ItemUtils.containsExplicitBadge( renderer.getBadges() ),
                album,
                artists,
                artists.stream ()
                       .map ( Runs.Run::getText )
                       .collect ( Collectors.joining ( ", " ) )
        );
    }
// END: Static fields/functions

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
    Runs.Run album;

    /**
     * List of artists featured in this song
     */
    @NotNull
    @Unmodifiable
    List<Runs.Run> authors;

    /**
     * All authors listed in 1 line, with delimiter in between
     */
    @NotNull
    String authorsText;

    public InnertubeSong(
            @NotNull String id,
            @NotNull String name,
            @NotNull List<? extends Thumbnails.Thumbnail> thumbnails,
            @NotNull String durationText,
            boolean explicit,
            @Nullable Runs.Run album,
            @NotNull List<? extends Runs.Run> authors,
            @NotNull String authorsText
    ) {
        super( id, name, thumbnails );
        this.durationText = durationText;
        this.explicit = explicit;
        this.album = album;
        this.authors = Collections.unmodifiableList ( authors );
        this.authorsText = authorsText;
    }
}
