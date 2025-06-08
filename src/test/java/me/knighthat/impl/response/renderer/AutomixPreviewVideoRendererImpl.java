package me.knighthat.impl.response.renderer;

import lombok.Data;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.renderer.AutomixPreviewVideoRenderer;

@Data
public class AutomixPreviewVideoRendererImpl implements AutomixPreviewVideoRenderer {

    private final Content content;

    @Data
    public static class ContentImpl implements AutomixPreviewVideoRenderer.Content {

        private final Renderer automixPlaylistVideoRenderer;

        @Data
        public static class Renderer implements AutomixPreviewVideoRenderer.Content.Renderer {

            private final Endpoint navigationEndpoint;
            private final String trackingParams;
            private final String automixMode;
        }
    }
}
