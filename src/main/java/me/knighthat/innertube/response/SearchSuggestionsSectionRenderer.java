package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

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