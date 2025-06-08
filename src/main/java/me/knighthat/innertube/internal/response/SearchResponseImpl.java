package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SearchResponse;

@Value
class SearchResponseImpl implements SearchResponse {

    ResponseContextImpl responseContext;
    ContentsImpl        contents;
    String              trackingParams;

    @Value
    static class ContentsImpl implements Contents {

        TabsImpl tabbedSearchResultsRenderer;
    }
}