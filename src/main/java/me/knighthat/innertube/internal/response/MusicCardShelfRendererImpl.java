package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicCardShelfRenderer;

import java.util.List;

@Value
class MusicCardShelfRendererImpl implements MusicCardShelfRenderer {

    String            trackingParams;
    ThumbnailImpl     thumbnail;
    RunsImpl          title;
    RunsImpl          subtitle;
    List<ContentImpl> contents;

    @Value
    static class ContentImpl implements Content {

        MessageRendererImpl                 messageRenderer;
        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;

        @Value
        static class MessageRendererImpl implements MessageRenderer {

            RunsImpl  text;
            String    trackingParams;
            StyleImpl style;

            @Value
            static class StyleImpl implements Style {

                String value;
            }
        }
    }
}