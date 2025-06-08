package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import me.knighthat.innertube.response.Trackable;

public interface MusicPlaylistShelfRenderer extends Trackable {

    @NotNull
    String getPlaylistId();

    @NotNull
    List<? extends Content> getContents();

    @NotNull
    Integer getCollapsedItemCount();

    @NotNull
    Boolean getContentsMultiSelectable();

    @NotNull
    String getTargetId();

    interface Content {

        @NotNull
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();
    }
}