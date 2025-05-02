package me.knighthat.impl.response.renderer;

import lombok.Data;
import me.knighthat.impl.response.EndpointImpl;
import me.knighthat.impl.response.IconImpl;
import me.knighthat.impl.response.RunsImpl;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.renderer.MusicResponsiveListItemRenderer;
import me.knighthat.innertube.response.renderer.SearchSuggestionsSectionRenderer;

import java.util.List;

@Data
public class SearchSuggestionsSectionRendererImpl implements SearchSuggestionsSectionRenderer {

    private final List<ContentImpl> contents;

    @Data
    public static class ContentImpl implements Content {

        private final MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        private final RendererImpl                    searchSuggestionRenderer;

        @Data
        public static class RendererImpl implements Renderer {

            private final RunsImpl     suggestion;
            private final EndpointImpl navigationEndpoint;
            private final String       trackingParams;
            private final IconImpl icon;
        }
    }
}