package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicCardShelfRenderer;

import java.util.List;

@Value
public class MusicCardShelfRendererImpl implements MusicCardShelfRenderer {

    String            trackingParams;
    ThumbnailImpl     thumbnail;
    RunsImpl          title;
    RunsImpl          subtitle;
    List<ContentImpl> contents;

    @Value
    public static class ContentImpl implements Content {

        MessageRendererImpl                 messageRenderer;
        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;

        @Value
        public static class MessageRendererImpl implements MessageRenderer {

            RunsImpl  text;
            String    trackingParams;
            StyleImpl style;

            @Value
            public static class StyleImpl implements Style {

                String value;
            }
        }
    }
}