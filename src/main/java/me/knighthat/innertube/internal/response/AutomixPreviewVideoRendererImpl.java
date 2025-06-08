package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.AutomixPreviewVideoRenderer;
import me.knighthat.innertube.response.Endpoint;

@Value
public class AutomixPreviewVideoRendererImpl implements AutomixPreviewVideoRenderer {

    ContentImpl content;

    @Value
    public static class ContentImpl implements Content {

        RendererImpl automixPlaylistVideoRenderer;

        @Value
        public static class RendererImpl implements Renderer {

            Endpoint navigationEndpoint;
            String   trackingParams;
            String   automixMode;
        }
    }
}
