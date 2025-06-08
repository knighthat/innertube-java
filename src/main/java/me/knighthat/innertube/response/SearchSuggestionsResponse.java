package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface SearchSuggestionsResponse extends Trackable, InnerTubeResponse {

    @NotNull
    ResponseContext getResponseContext();

    @NotNull
    List<? extends Content> getContents();

    interface Content {

        @NotNull
        SearchSuggestionsSectionRenderer getSearchSuggestionsSectionRenderer();
    }
}