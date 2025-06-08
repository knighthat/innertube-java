package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.ChipCloud;

import java.util.List;

@Value
class ChipCloudImpl implements ChipCloud {

    List<ChipImpl> chips;
    String         trackingParams;
    Boolean        horizontalScrollable;
    Integer        collapsedRowCount;

    @Value
    static class ChipImpl implements Chip {

        RendererImpl chipCloudChipRenderer;

        @Value
        static class RendererImpl implements Renderer {

            StyleImpl         style;
            RunsImpl          text;
            EndpointImpl      navigationEndpoint;
            String            trackingParams;
            IconImpl          icon;
            AccessibilityImpl accessibilityData;
            Boolean           isSelected;
            EndpointImpl      onDeselectedCommand;
            String            uniqueId;

            @Value
            static class StyleImpl implements Style {

                String styleType;
            }
        }
    }
}