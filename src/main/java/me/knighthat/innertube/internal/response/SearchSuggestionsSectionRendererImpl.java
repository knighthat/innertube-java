package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SearchSuggestionsSectionRenderer;

import java.util.List;

@Value
class SearchSuggestionsSectionRendererImpl implements SearchSuggestionsSectionRenderer {

    List<ContentImpl> contents;

    @Value
    static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        RendererImpl                        searchSuggestionRenderer;

        @Value
        static class RendererImpl implements Renderer {

            RunsImpl     suggestion;
            EndpointImpl navigationEndpoint;
            String       trackingParams;
            IconImpl     icon;
        }
    }
}