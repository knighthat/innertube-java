package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SearchSuggestionsResponse;

import java.util.List;

@Value
class SearchSuggestionsResponseImpl implements SearchSuggestionsResponse {

    ResponseContextImpl responseContext;
    List<ContentImpl>   contents;
    String              trackingParams;

    @Value
    static class ContentImpl implements Content {

        SearchSuggestionsSectionRendererImpl searchSuggestionsSectionRenderer;
    }
}