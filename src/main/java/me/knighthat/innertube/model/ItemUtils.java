package me.knighthat.innertube.model;

import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.Runs;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

class ItemUtils {

// START: Static fields/functions
    static @NotNull String getFirstText( @NotNull Runs runs ) {
        return Objects.requireNonNull( runs.getRuns()
                                           .getFirst()
                                           .getText() );
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
// END: Static fields/functions
}
