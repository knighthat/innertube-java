package me.knighthat.innertube.response;

public interface Badge {

    MusicInlineBadgeRenderer getMusicInlineBadgeRenderer();

    interface MusicInlineBadgeRenderer {

        String getTrackingParams();

        Icon getIcon();

        Accessibility getAccessibilityData();
    }
}
