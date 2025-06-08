package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Button;

import java.util.List;

@Value
class ButtonImpl implements Button {

    RendererImpl                        buttonRenderer;
    ToggleImpl                          toggleButtonRenderer;
    ChipCloudImpl.ChipImpl.RendererImpl chipCloudChipRenderer;
    LikeImpl                            likeButtonRenderer;
    SubscribeImpl                       subscribeButtonRenderer;

    @Value
    static class RendererImpl implements Renderer {

        String                     style;
        Boolean                    isDisabled;
        String                     size;
        RunsImpl                   text;
        IconImpl                   icon;
        EndpointImpl               navigationEndpoint;
        EndpointImpl               serviceEndpoint;
        String                     trackingParams;
        AccessibilityImpl.DataImpl accessibility;
        AccessibilityImpl          accessibilityData;
    }

    @Value
    static class LikeImpl implements Like {

        TargetImpl   target;
        String       likeStatus;
        String       trackingParams;
        Boolean      likesAllowed;
        EndpointImpl dislikeNavigationEndpoint;
        EndpointImpl likeCommand;

        @Value
        static class TargetImpl implements Target {

            String videoId;
        }
    }

    @Value
    static class MusicPlayImpl implements MusicPlay {

        EndpointImpl      playNavigationEndpoint;
        String            trackingParams;
        IconImpl          playIcon;
        IconImpl          pauseIcon;
        Long              iconColor;
        Long              backgroundColor;
        Long              activeBackgroundColor;
        Long              loadingIndicatorColor;
        IconImpl          playingIcon;
        Long              iconLoadingColor;
        Float             activeScaleFactor;
        String            buttonSize;
        String            rippleTarget;
        AccessibilityImpl accessibilityPlayData;
        AccessibilityImpl accessibilityPauseData;
    }

    @Value
    static class ToggleImpl implements Toggle {

        Boolean           isToggled;
        Boolean           isDisabled;
        IconImpl          defaultIcon;
        EndpointImpl      defaultServiceEndpoint;
        RunsImpl          defaultText;
        IconImpl          toggledIcon;
        EndpointImpl      toggledServiceEndpoint;
        RunsImpl          toggledText;
        String            trackingParams;
        EndpointImpl      defaultNavigationEndpoint;
        AccessibilityImpl accessibilityData;
        AccessibilityImpl toggledAccessibilityData;
    }

    @Value
    static class SubscribeImpl implements Subscribe {

        String             trackingParams;
        RunsImpl           subscriberCountText;
        Boolean            subscribed;
        Boolean            enabled;
        String             type;
        String             channelId;
        Boolean            showPreference;
        RunsImpl           subscriberCountWithSubscribeText;
        RunsImpl           subscribedButtonText;
        RunsImpl           unsubscribedButtonText;
        RunsImpl           unsubscribeButtonText;
        List<EndpointImpl> serviceEndpoints;
        RunsImpl           longSubscriberCountText;
        RunsImpl           shortSubscriberCountText;
        AccessibilityImpl  subscribeAccessibility;
        AccessibilityImpl  unsubscribeAccessibility;
        EndpointImpl       signInEndpoint;
    }
}