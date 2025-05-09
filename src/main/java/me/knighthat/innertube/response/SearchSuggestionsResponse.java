package me.knighthat.innertube.response;

import me.knighthat.innertube.response.renderer.SearchSuggestionsSectionRenderer;

import java.util.List;

public interface SearchSuggestionsResponse extends Trackable {

    ResponseContext getResponseContext();

    List<? extends Content> getContents();

    interface Content {

        SearchSuggestionsSectionRenderer getSearchSuggestionsSectionRenderer();
    }
}