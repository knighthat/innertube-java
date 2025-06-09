package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Badge {

    // START: Static fields/functions
    @NotNull String EXPLICIT = "MUSIC_EXPLICIT_BADGE";
    // END: Static fields/functions

    @Nullable
    Renderer getMusicInlineBadgeRenderer();

    @Nullable
    Renderer getMetadataBadgeRenderer();

    interface Renderer extends Trackable {

        @NotNull
        Icon getIcon();

        @Nullable
        String getStyle();

        @Nullable
        String getTooltip();

        @Nullable
        Accessibility getAccessibilityData();
    }
}
