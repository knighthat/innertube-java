package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Trackable;

import java.util.List;

public interface MusicShelfRenderer extends Trackable {

    @NotNull
    Runs getTitle();

    @NotNull
    List<? extends Content> getContents();

    @Nullable
    Runs getBottomText();

    @Nullable
    Endpoint getBottomEndpoint();

    @Nullable
    ShelfDivider getShelfDivider();

    @Nullable
    Boolean getContentsMultiSelectable();

    interface Content {

        @NotNull
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();
    }

    interface ShelfDivider {

        @NotNull
        Renderer getMusicShelfDividerRenderer();

        interface Renderer {

            @NotNull
            Boolean getHidden();
        }
    }
}