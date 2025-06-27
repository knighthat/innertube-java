package me.knighthat.innertube.model;

import me.knighthat.innertube.PageType;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

class ItemUtils {

// START: Static fields/functions
    static @NotNull String getFirstText( @NotNull Runs runs ) {
        return Objects.requireNonNull(
                runs.getRuns().get( 0 ).getText()
        );
    }

    /**
     * @return whether explicit badge exists in this list of badges
     */
    static boolean containsExplicitBadge( @NotNull List<? extends Badge> badges ) {
        return badges.stream()
                     .anyMatch( badge ->
                                        badge.getMusicInlineBadgeRenderer() != null
                                        && badge.getMusicInlineBadgeRenderer()
                                                .getIcon()
                                                .getIconType()
                                                .equals( Badge.EXPLICIT )
                     );
    }

    static @NotNull @Unmodifiable List<Thumbnails.Thumbnail> extractThumbnail( @Nullable Thumbnail thumbnail ) {
        return thumbnail == null ? Collections.emptyList()
                : Collections.unmodifiableList( thumbnail.getMusicThumbnailRenderer()
                                                         .getThumbnail()
                                                         .getThumbnails() );
    }

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
    static @NotNull LinkedList<Endpoint.Browse> extractArtistsAndAlbum( @NotNull List<? extends Runs.Run> runs ) {
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

        // LinkedList supports `null` element
        LinkedList<Endpoint.Browse> results = new LinkedList<>( authors );
        results.addFirst( album );

        // This Deque can't be empty under any circumstances
        assert !results.isEmpty();

        return results;
    }
// END: Static fields/functions
}
