package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Trackable;

import java.util.List;

public interface ChipCloud extends Trackable {

    List<? extends Chip> getChips();

    Boolean getHorizontalScrollable();

    interface Chip {

        Renderer getChipCloudChipRenderer();

        interface Renderer extends Trackable {

            Style getStyle();

            Runs getText();

            Endpoint getNavigationEndpoint();

            Icon getIcon();

            Accessibility getAccessibilityData();

            Boolean getIsSelected();

            Endpoint getOnDeselectedCommand();

            String getUniqueId();

            interface Style {

                String getStyleType();
            }
        }
    }
}