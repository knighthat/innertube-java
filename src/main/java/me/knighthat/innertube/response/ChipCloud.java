package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ChipCloud extends Trackable {

    @NotNull
    List<? extends Chip> getChips();

    @Nullable
    Boolean getHorizontalScrollable();

    @Nullable
    Integer getCollapsedRowCount();

    interface Chip {

        Renderer getChipCloudChipRenderer();

        interface Renderer extends Trackable {

            @NotNull
            Style getStyle();

            @NotNull
            Runs getText();

            @NotNull
            Endpoint getNavigationEndpoint();

            @NotNull
            Icon getIcon();

            @Nullable
            Accessibility getAccessibilityData();

            @NotNull
            Boolean getIsSelected();

            @Nullable
            Endpoint getOnDeselectedCommand();

            @NotNull
            String getUniqueId();

            interface Style {

                @NotNull
                String getStyleType();
            }
        }
    }
}