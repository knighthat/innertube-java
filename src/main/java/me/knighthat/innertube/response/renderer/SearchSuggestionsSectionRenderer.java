package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;

import java.util.List;

public interface SearchSuggestionsSectionRenderer {

    List<? extends Content> getContents();

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        Renderer getSearchSuggestionRenderer();

        interface Renderer {

            Runs getSuggestion();

            Endpoint getNavigationEndpoint();

            String getTrackingParams();

            Icon getIcon();
        }
    }
}