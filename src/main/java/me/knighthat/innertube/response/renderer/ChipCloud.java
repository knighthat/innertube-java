package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;

import java.util.List;

public interface ChipCloud {

    List<Chip> getChips();

    interface Chip {

        Renderer getChipCloudChipRenderer();

        interface Renderer {

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
    }
}