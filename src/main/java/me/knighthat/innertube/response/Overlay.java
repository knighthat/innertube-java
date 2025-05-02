package me.knighthat.innertube.response;

import me.knighthat.innertube.response.button.MusicPlayButtonRenderer;

import java.util.List;

public interface Overlay {

    MusicItemThumbnailOverlayRenderer getMusicItemThumbnailOverlayRenderer();

    interface MusicItemThumbnailOverlayRenderer {

        Background getBackground();

        Content getContent();

        String getContentPosition();

        String getDisplayStyle();

        interface Background {

            VerticalGradient getVerticalGradient();

            interface VerticalGradient {

                List<String> getGradientLayerColors();
            }
        }

        interface Content {

            MusicPlayButtonRenderer getMusicPlayButtonRenderer();
        }
    }
}