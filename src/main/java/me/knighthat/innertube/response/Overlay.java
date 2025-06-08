package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Overlay {

    @NotNull
    MusicItemThumbnailOverlayRenderer getMusicItemThumbnailOverlayRenderer();

    interface MusicItemThumbnailOverlayRenderer {

        @NotNull
        Background getBackground();

        @NotNull
        Content getContent();

        @NotNull
        String getContentPosition();

        @NotNull
        String getDisplayStyle();

        interface Background {

            @NotNull
            VerticalGradient getVerticalGradient();

            interface VerticalGradient {

                @NotNull
                List<String> getGradientLayerColors();
            }
        }

        interface Content {

            @NotNull
            Button.MusicPlay getMusicPlayButtonRenderer();
        }
    }
}