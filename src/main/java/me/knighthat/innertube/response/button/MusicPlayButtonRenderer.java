package me.knighthat.innertube.response.button;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.endpoint.Endpoint;

public interface MusicPlayButtonRenderer {

    Endpoint getPlayNavigationEndpoint();

    String getTrackingParams();

    Icon getPlayIcon();

    Icon getPauseIcon();

    Long getIconColor();

    Long getBackgroundColor();

    Long getActiveBackgroundColor();

    Long getLoadingIndicatorColor();

    Icon getPlayingIcon();

    Long getIconLoadingColor();

    Float getActiveScaleFactor();

    String getButtonSize();

    String getRippleTarget();

    Accessibility getAccessibilityPlayData();

    Accessibility getAccessibilityPauseData();
}