package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicCarouselShelfRenderer;

import java.util.List;

@Value
class MusicCarouselShelfRendererImpl implements MusicCarouselShelfRenderer {

    HeaderImpl        header;
    List<ContentImpl> contents;
    String            trackingParams;
    String            itemSize;
    String            numItemsPerColumn;

    @Value
    static class HeaderImpl implements Header {

        MusicCarouselShelfBasicHeaderRendererImpl musicCarouselShelfBasicHeaderRenderer;

        @Value
        static class MusicCarouselShelfBasicHeaderRendererImpl implements MusicCarouselShelfBasicHeaderRenderer {

            RunsImpl          title;
            RunsImpl          strapline;
            AccessibilityImpl accessibilityData;
            String            headerStyle;
            ButtonImpl        moreContentButton;
            String            trackingParams;
        }
    }

    @Value
    static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        MusicTwoRowItemRendererImpl         musicTwoRowItemRenderer;
    }
}