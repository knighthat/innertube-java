package me.knighthat.innertube.response.button;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;

public interface ToggleButtonRenderer {

    Boolean getIsToggled();

    Boolean getIsDisabled();

    Icon getDefaultIcon();

    Endpoint getDefaultServiceEndpoint();

    Runs getDefaultText();

    Icon getToggledIcon();

    Endpoint getToggledServiceEndpoint();

    Runs getToggledText();

    String getTrackingParams();

    Endpoint getDefaultNavigationEndpoint();

    Accessibility getAccessibilityData();

    Accessibility getToggledAccessibilityData();
}