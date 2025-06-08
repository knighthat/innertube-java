package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Overlay;

import java.util.List;

@Value
public class OverlayImpl implements Overlay {

    MusicItemThumbnailOverlayRendererImpl musicItemThumbnailOverlayRenderer;

    @Value
    public static class MusicItemThumbnailOverlayRendererImpl implements MusicItemThumbnailOverlayRenderer {

        BackgroundImpl background;
        ContentImpl    content;
        String         contentPosition;
        String         displayStyle;

        @Value
        public static class BackgroundImpl implements Background {

            VerticalGradientImpl verticalGradient;

            @Value
            public static class VerticalGradientImpl implements VerticalGradient {

                List<String> gradientLayerColors;
            }
        }

        @Value
        public static class ContentImpl implements Content {

            ButtonImpl.MusicPlayImpl musicPlayButtonRenderer;
        }
    }
}