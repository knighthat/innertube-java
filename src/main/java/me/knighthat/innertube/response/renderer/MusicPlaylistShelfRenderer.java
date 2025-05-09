package me.knighthat.innertube.response.renderer;

import java.util.List;

import me.knighthat.innertube.response.Trackable;

public interface MusicPlaylistShelfRenderer extends Trackable {

    String getPlaylistId();

    List<? extends Content> getContents();

    Integer getCollapsedItemCount();

    Boolean getContentsMultiSelectable();

    String getTargetId();

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();
    }
}