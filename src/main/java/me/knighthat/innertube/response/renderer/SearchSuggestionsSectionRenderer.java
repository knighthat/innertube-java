package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;

import java.util.List;

public interface SearchSuggestionsSectionRenderer {

    List<Content> getContents();

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        SearchSuggestionRenderer getSearchSuggestionRenderer();

        interface SearchSuggestionRenderer {

            Runs getSuggestion();

            Endpoint getNavigationEndpoint();

            String getTrackingParams();

            Icon getIcon();
        }
    }
}