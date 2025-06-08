package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Badge;

@Value
class BadgeImpl implements Badge {

    RendererImpl musicInlineBadgeRenderer;
    RendererImpl metadataBadgeRenderer;

    @Value
    static class RendererImpl implements Renderer {

        String            trackingParams;
        IconImpl          icon;
        String            style;
        String            tooltip;
        AccessibilityImpl accessibilityData;
    }
}
