package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

import java.util.List;

public interface PlaylistPanelRenderer {

    List<Content> getContents();

    String getPlaylistId();

    Boolean getIsInfinite();

    List<Continuation> getContinuations();

    String getTrackingParams();

    Short getNumItemsToShow();

    Button getShuffleToggleButton();

    interface Content {

        VideoRenderer getPlaylistPanelVideoRenderer();

        AutomixPreviewVideoRenderer getAutomixPreviewVideoRenderer();

        interface VideoRenderer {

            Runs getTitle();

            Runs getLongBylineText();

            Thumbnails getThumbnail();

            Runs getLengthText();

            Boolean getSelected();

            Endpoint getNavigationEndpoint();

            String getVideoId();

            Runs getShortBylineText();

            List<Badge> getBadges();

            String getTrackingParams();

            Menu getMenu();

            String getPlaylistSetVideoId();

            Boolean getCanReorder();

            Endpoint getQueueNavigationEndpoint();

        }
    }
}