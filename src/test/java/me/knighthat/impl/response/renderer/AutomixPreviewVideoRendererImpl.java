package me.knighthat.impl.response.renderer;

import lombok.Data;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.AutomixPreviewVideoRenderer;

@Data
public class AutomixPreviewVideoRendererImpl implements AutomixPreviewVideoRenderer {

    private final ContentImpl content;

    @Data
    public static class ContentImpl implements AutomixPreviewVideoRenderer.Content {

        private final RendererImpl automixPlaylistVideoRenderer;

        @Data
        public static class RendererImpl implements AutomixPreviewVideoRenderer.Content.Renderer {

            private final Endpoint navigationEndpoint;
            private final String trackingParams;
            private final String automixMode;
        }
    }
}
