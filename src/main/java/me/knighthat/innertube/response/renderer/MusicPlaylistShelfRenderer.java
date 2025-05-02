package me.knighthat.innertube.response.renderer;

import java.util.List;

public interface MusicPlaylistShelfRenderer {

    String getPlaylistId();

    List<? extends Content> getContents();

    Integer getCollapsedItemCount();

    String getTrackingParams();

    Boolean getContentsMultiSelectable();

    String getTargetId();

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();
    }
}