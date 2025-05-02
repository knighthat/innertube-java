package me.knighthat.innertube.response.endpoint;

public interface BrowseEndpoint {

    String getBrowseId();

    String getParams();

    BrowseEndpointContextSupportedConfigs getBrowseEndpointContextSupportedConfigs();

    interface BrowseEndpointContextSupportedConfigs {

        BrowseEndpointContextMusicConfig getBrowseEndpointContextMusicConfig();

        interface BrowseEndpointContextMusicConfig {

            String getPageType();
        }
    }
}