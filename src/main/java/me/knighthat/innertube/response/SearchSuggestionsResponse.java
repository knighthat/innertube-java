package me.knighthat.innertube.response;

import me.knighthat.innertube.response.renderer.SearchSuggestionsSectionRenderer;

import java.util.List;

public interface SearchSuggestionsResponse {

    ResponseContext getResponseContext();

    List<Content> getContents();

    String getTrackingParams();

    interface Content {

        SearchSuggestionsSectionRenderer getSearchSuggestionsSectionRenderer();
    }
}