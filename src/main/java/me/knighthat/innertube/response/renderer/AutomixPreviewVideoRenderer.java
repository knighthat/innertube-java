package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Trackable;

public interface AutomixPreviewVideoRenderer {

    @NotNull
    Content getContent();

    interface Content {

        @NotNull
        Renderer getAutomixPlaylistVideoRenderer();

        interface Renderer extends Trackable {

            @NotNull
            Endpoint getNavigationEndpoint();

            @NotNull
            String getAutomixMode();
        }
    }
}
