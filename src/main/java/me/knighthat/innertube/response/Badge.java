package me.knighthat.innertube.response;

public interface Badge {

    Renderer getMusicInlineBadgeRenderer();

    interface Renderer {

        String getTrackingParams();

        Icon getIcon();

        Accessibility getAccessibilityData();
    }
}
