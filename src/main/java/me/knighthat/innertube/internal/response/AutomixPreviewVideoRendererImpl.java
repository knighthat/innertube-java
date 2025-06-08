package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.AutomixPreviewVideoRenderer;
import me.knighthat.innertube.response.Endpoint;

@Value
class AutomixPreviewVideoRendererImpl implements AutomixPreviewVideoRenderer {

    ContentImpl content;

    @Value
    static class ContentImpl implements Content {

        RendererImpl automixPlaylistVideoRenderer;

        @Value
        static class RendererImpl implements Renderer {

            Endpoint navigationEndpoint;
            String   trackingParams;
            String   automixMode;
        }
    }
}
