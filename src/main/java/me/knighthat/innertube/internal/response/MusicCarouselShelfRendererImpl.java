package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicCarouselShelfRenderer;

import java.util.List;

@Value
public class MusicCarouselShelfRendererImpl implements MusicCarouselShelfRenderer {

    HeaderImpl        header;
    List<ContentImpl> contents;
    String            trackingParams;
    String            itemSize;
    String            numItemsPerColumn;

    @Value
    public static class HeaderImpl implements Header {

        MusicCarouselShelfBasicHeaderRendererImpl musicCarouselShelfBasicHeaderRenderer;

        @Value
        public static class MusicCarouselShelfBasicHeaderRendererImpl implements MusicCarouselShelfBasicHeaderRenderer {

            RunsImpl          title;
            RunsImpl          strapline;
            AccessibilityImpl accessibilityData;
            String            headerStyle;
            ButtonImpl        moreContentButton;
            String            trackingParams;
        }
    }

    @Value
    public static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        MusicTwoRowItemRendererImpl         musicTwoRowItemRenderer;
    }
}