package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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