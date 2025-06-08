package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Overlay;

import java.util.List;

@Value
class OverlayImpl implements Overlay {

    MusicItemThumbnailOverlayRendererImpl musicItemThumbnailOverlayRenderer;

    @Value
    static class MusicItemThumbnailOverlayRendererImpl implements MusicItemThumbnailOverlayRenderer {

        BackgroundImpl background;
        ContentImpl    content;
        String         contentPosition;
        String         displayStyle;

        @Value
        static class BackgroundImpl implements Background {

            VerticalGradientImpl verticalGradient;

            @Value
            static class VerticalGradientImpl implements VerticalGradient {

                List<String> gradientLayerColors;
            }
        }

        @Value
        static class ContentImpl implements Content {

            ButtonImpl.MusicPlayImpl musicPlayButtonRenderer;
        }
    }
}