package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Badge {

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
