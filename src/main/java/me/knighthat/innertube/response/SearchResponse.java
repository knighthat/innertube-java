package me.knighthat.innertube.response;

public interface SearchResponse {

    ResponseContext getResponseContext();

    Contents getContents();

    String getTrackingParams();

    interface Contents {

        Tabs getTabbedSearchResultsRenderer();
    }
}