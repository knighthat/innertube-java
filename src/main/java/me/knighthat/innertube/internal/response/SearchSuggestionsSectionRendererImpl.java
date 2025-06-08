package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SearchSuggestionsSectionRenderer;

import java.util.List;

@Value
public class SearchSuggestionsSectionRendererImpl implements SearchSuggestionsSectionRenderer {

    List<ContentImpl> contents;

    @Value
    public static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        RendererImpl                        searchSuggestionRenderer;

        @Value
        public static class RendererImpl implements Renderer {

            RunsImpl     suggestion;
            EndpointImpl navigationEndpoint;
            String       trackingParams;
            IconImpl     icon;
        }
    }
}