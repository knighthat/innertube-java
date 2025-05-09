package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

import java.util.List;

public interface PlaylistPanelRenderer extends Trackable {

    List<? extends Content> getContents();

    String getPlaylistId();

    Boolean getIsInfinite();

    List<? extends Continuation> getContinuations();

    Short getNumItemsToShow();

    Button getShuffleToggleButton();

    interface Content {

        VideoRenderer getPlaylistPanelVideoRenderer();

        AutomixPreviewVideoRenderer getAutomixPreviewVideoRenderer();

        interface VideoRenderer extends Trackable {

            Runs getTitle();

            Runs getLongBylineText();

            Thumbnails getThumbnail();

            Runs getLengthText();

            Boolean getSelected();

            Endpoint getNavigationEndpoint();

            String getVideoId();

            Runs getShortBylineText();

            List<? extends Badge> getBadges();

            Menu getMenu();

            String getPlaylistSetVideoId();

            Boolean getCanReorder();

            Endpoint getQueueNavigationEndpoint();

        }
    }
}