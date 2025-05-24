package me.knighthat.innertube.response;

public interface Badge {

    Renderer getMusicInlineBadgeRenderer();

    Renderer getMetadataBadgeRenderer();

    interface Renderer extends Trackable {

        Icon getIcon();

        String getStyle();

        String getTooltip();

        Accessibility getAccessibilityData();
    }
}
