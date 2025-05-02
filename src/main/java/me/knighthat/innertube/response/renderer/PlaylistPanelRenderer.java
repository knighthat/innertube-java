package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.Continuation;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;
import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.menu.Menu;
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

        PlaylistPanelVideoRenderer getPlaylistPanelVideoRenderer();

        AutomixPreviewVideoRenderer getAutomixPreviewVideoRenderer();

        interface PlaylistPanelVideoRenderer {

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