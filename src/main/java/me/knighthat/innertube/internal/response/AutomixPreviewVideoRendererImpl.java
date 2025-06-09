package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.AutomixPreviewVideoRenderer;

@Value
class AutomixPreviewVideoRendererImpl implements AutomixPreviewVideoRenderer {

    ContentImpl content;

    @Value
    static class ContentImpl implements Content {

        RendererImpl automixPlaylistVideoRenderer;

        @Value
        static class RendererImpl implements Renderer {

            EndpointImpl navigationEndpoint;
            String       trackingParams;
            String       automixMode;
        }
    }
}
