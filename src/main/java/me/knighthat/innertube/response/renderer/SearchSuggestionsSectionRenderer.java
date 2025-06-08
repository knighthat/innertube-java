package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Trackable;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SearchSuggestionsSectionRenderer {

    @NotNull
    List<? extends Content> getContents();

    interface Content {

        @Nullable
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        @Nullable
        Renderer getSearchSuggestionRenderer();

        interface Renderer extends Trackable {

            @NotNull
            Runs getSuggestion();

            @NotNull
            Endpoint getNavigationEndpoint();

            @Nullable
            Icon getIcon();
        }
    }
}