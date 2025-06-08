package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

public interface SearchResponse extends Trackable, InnerTubeResponse {

    @NotNull
    ResponseContext getResponseContext();

    @NotNull
    Contents getContents();

    interface Contents {

        @NotNull
        Tabs getTabbedSearchResultsRenderer();
    }
}