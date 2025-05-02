package me.knighthat.innertube.response;

import me.knighthat.innertube.response.renderer.ChipCloudRenderer;

public interface Button {

    ButtonRenderer getButtonRenderer();

    ToggleButtonRenderer getToggleButtonRenderer();

    ChipCloudRenderer.Chip.ChipCloudChipRenderer getChipCloudChipRenderer();

    LikeButtonRenderer getLikeButtonRenderer();

    interface ButtonRenderer {

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

    interface LikeButtonRenderer {

        Target getTarget();

        String getLikeStatus();

        String getTrackingParams();

        Boolean getLikesAllowed();

        Endpoint getDislikeNavigationEndpoint();

        Endpoint getLikeCommand();

        interface Target {

            String getVideoId();
        }
    }

    interface MusicPlayButtonRenderer {

        Endpoint getPlayNavigationEndpoint();

        String getTrackingParams();

        Icon getPlayIcon();

        Icon getPauseIcon();

        Long getIconColor();

        Long getBackgroundColor();

        Long getActiveBackgroundColor();

        Long getLoadingIndicatorColor();

        Icon getPlayingIcon();

        Long getIconLoadingColor();

        Float getActiveScaleFactor();

        String getButtonSize();

        String getRippleTarget();

        Accessibility getAccessibilityPlayData();

        Accessibility getAccessibilityPauseData();
    }

    interface ToggleButtonRenderer {

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
}