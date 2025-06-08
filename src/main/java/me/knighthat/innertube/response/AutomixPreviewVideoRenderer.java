package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

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
