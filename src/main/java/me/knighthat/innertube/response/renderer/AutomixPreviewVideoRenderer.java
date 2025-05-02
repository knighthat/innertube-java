package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.endpoint.Endpoint;

public interface AutomixPreviewVideoRenderer {

    Content getContent();

    interface Content {

        AutomixPlaylistVideoRenderer getAutomixPlaylistVideoRenderer();

        interface AutomixPlaylistVideoRenderer {

            Endpoint getNavigationEndpoint();

            String getTrackingParams();

            String getAutomixMode();
        }
    }
}