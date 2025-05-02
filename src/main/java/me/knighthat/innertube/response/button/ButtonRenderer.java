package me.knighthat.innertube.response.button;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;

public interface ButtonRenderer {

    String getStyle();

    Boolean getIsDisabled();

    String getSize();

    Runs getText();

    Icon getIcon();

    Endpoint getNavigationEndpoint();

    String getTrackingParams();

    Accessibility.Data getAccessibility();

    Accessibility getAccessibilityData();
}