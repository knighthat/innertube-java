package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicShelfRenderer;

import java.util.List;

@Value
public class MusicShelfRendererImpl implements MusicShelfRenderer {

    RunsImpl          title;
    List<ContentImpl> contents;
    String            trackingParams;
    RunsImpl          bottomText;
    EndpointImpl      bottomEndpoint;
    ShelfDividerImpl  shelfDivider;
    Boolean           contentsMultiSelectable;

    @Value
    public static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
    }

    @Value
    public static class ShelfDividerImpl implements ShelfDivider {

        RendererImpl musicShelfDividerRenderer;

        @Value
        public static class RendererImpl implements Renderer {

            Boolean hidden;
        }
    }
}