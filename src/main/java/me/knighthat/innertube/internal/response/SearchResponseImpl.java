package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SearchResponse;

@Value
public class SearchResponseImpl implements SearchResponse {

    ResponseContextImpl responseContext;
    ContentsImpl        contents;
    String              trackingParams;

    @Value
    public static class ContentsImpl implements Contents {

        TabsImpl tabbedSearchResultsRenderer;
    }
}