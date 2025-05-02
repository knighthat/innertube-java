package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;

public interface ChipCloudChipRenderer {

    Style getStyle();

    Runs getText();

    Endpoint getNavigationEndpoint();

    String getTrackingParams();

    Icon getIcon();

    Accessibility getAccessibilityData();

    Boolean getIsSelected();

    String getUniqueId();


    interface Style {

        String getStyleType();
    }
}