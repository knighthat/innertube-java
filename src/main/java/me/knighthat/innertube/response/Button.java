package me.knighthat.innertube.response;

import java.util.List;

import me.knighthat.innertube.response.renderer.ChipCloud;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Button {

    @Nullable
    Renderer getButtonRenderer();

    @Nullable
    Toggle getToggleButtonRenderer();

    @Nullable
    ChipCloud.Chip.Renderer getChipCloudChipRenderer();

    @Nullable
    Like getLikeButtonRenderer();

    @Nullable
    Subscribe getSubscribeButtonRenderer();

    interface Renderer extends Trackable {

        @Nullable
        String getStyle();

        @Nullable
        Boolean getIsDisabled();

        @Nullable
        String getSize();

        @Nullable
        Runs getText();

        @Nullable
        Icon getIcon();

        @Nullable
        Endpoint getNavigationEndpoint();

        @Nullable
        Endpoint getServiceEndpoint();

        @Nullable
        Accessibility.Data getAccessibility();

        @Nullable
        Accessibility getAccessibilityData();
    }

    interface Like extends Trackable {

        @Nullable
        Target getTarget();

        @Nullable
        String getLikeStatus();

        @Nullable
        Boolean getLikesAllowed();

        @Nullable
        Endpoint getDislikeNavigationEndpoint();

        @Nullable
        Endpoint getLikeCommand();

        interface Target {

            @NotNull
            String getVideoId();
        }
    }

    interface MusicPlay extends Trackable {

        @NotNull
        Endpoint getPlayNavigationEndpoint();

        @NotNull
        Icon getPlayIcon();

        @NotNull
        Icon getPauseIcon();

        @NotNull
        Long getIconColor();

        @NotNull
        Long getBackgroundColor();

        @Nullable
        Long getActiveBackgroundColor();

        @Nullable
        Long getLoadingIndicatorColor();

        @Nullable
        Icon getPlayingIcon();

        @NotNull
        Long getIconLoadingColor();

        @NotNull
        Float getActiveScaleFactor();

        @Nullable
        String getButtonSize();

        @Nullable
        String getRippleTarget();

        @Nullable
        Accessibility getAccessibilityPlayData();

        @Nullable
        Accessibility getAccessibilityPauseData();
    }

    interface Toggle extends Trackable {

        @Nullable
        Boolean getIsToggled();

        @Nullable
        Boolean getIsDisabled();

        @Nullable
        Icon getDefaultIcon();

        @Nullable
        Endpoint getDefaultServiceEndpoint();

        @Nullable
        Runs getDefaultText();

        @Nullable
        Icon getToggledIcon();

        @Nullable
        Endpoint getToggledServiceEndpoint();

        @Nullable
        Runs getToggledText();

        @Nullable
        Endpoint getDefaultNavigationEndpoint();

        @Nullable
        Accessibility getAccessibilityData();

        @Nullable
        Accessibility getToggledAccessibilityData();
    }

    interface Subscribe extends Trackable {

        @NotNull
        Runs getSubscriberCountText();

        @Nullable
        Boolean getSubscribed();

        @Nullable
        Boolean getEnabled();

        @Nullable
        String getType();

        @NotNull
        String getChannelId();

        @Nullable
        Boolean getShowPreference();

        @Nullable
        Runs getSubscriberCountWithSubscribeText();

        @Nullable
        Runs getSubscribedButtonText();

        @Nullable
        Runs getUnsubscribedButtonText();

        @Nullable
        Runs getUnsubscribeButtonText();

        @NotNull
        List<? extends Endpoint> getServiceEndpoints();

        @NotNull
        Runs getLongSubscriberCountText();

        @NotNull
        Runs getShortSubscriberCountText();

        @Nullable
        Accessibility getSubscribeAccessibility();

        @Nullable
        Accessibility getUnsubscribeAccessibility();

        @Nullable
        Endpoint getSignInEndpoint();
    }
}