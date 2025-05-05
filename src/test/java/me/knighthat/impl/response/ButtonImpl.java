package me.knighthat.impl.response;

import lombok.Data;
import me.knighthat.impl.response.renderer.ChipCloudImpl;
import me.knighthat.innertube.response.Button;

@Data
public class ButtonImpl implements Button {

    private final RendererImpl            buttonRenderer;
    private final ToggleImpl                  toggleButtonRenderer;
    private final ChipCloudImpl.ChipImpl.RendererImpl chipCloudChipRenderer;
    private final LikeImpl                    likeButtonRenderer;

    @Data
    public static class RendererImpl implements Renderer {

        private final String style;
        private final Boolean isDisabled;
        private final String size;
        private final RunsImpl text;
        private final IconImpl icon;
        private final EndpointImpl navigationEndpoint;
        private final String                     trackingParams;
        private final AccessibilityImpl.DataImpl accessibility;
        private final AccessibilityImpl          accessibilityData;
    }

    @Data
    public static class LikeImpl implements Like {

        private final TargetImpl target;
        private final String     likeStatus;
        private final String trackingParams;
        private final Boolean likesAllowed;
        private final EndpointImpl dislikeNavigationEndpoint;
        private final EndpointImpl likeCommand;

        @Data
        public static class TargetImpl implements Target {

            private final String videoId;
        }
    }

    @Data
    public static class MusicPlayImpl implements MusicPlay {

        private final EndpointImpl playNavigationEndpoint;
        private final String trackingParams;
        private final IconImpl playIcon;
        private final IconImpl pauseIcon;
        private final Long iconColor;
        private final Long backgroundColor;
        private final Long activeBackgroundColor;
        private final Long loadingIndicatorColor;
        private final IconImpl playingIcon;
        private final Long iconLoadingColor;
        private final Float activeScaleFactor;
        private final String buttonSize;
        private final String rippleTarget;
        private final AccessibilityImpl accessibilityPlayData;
        private final AccessibilityImpl accessibilityPauseData;
    }

    @Data
    public static class ToggleImpl implements Toggle {

        private final Boolean isToggled;
        private final Boolean isDisabled;
        private final IconImpl defaultIcon;
        private final EndpointImpl defaultServiceEndpoint;
        private final RunsImpl defaultText;
        private final IconImpl toggledIcon;
        private final EndpointImpl toggledServiceEndpoint;
        private final RunsImpl toggledText;
        private final String trackingParams;
        private final EndpointImpl defaultNavigationEndpoint;
        private final AccessibilityImpl accessibilityData;
        private final AccessibilityImpl toggledAccessibilityData;
    }
}