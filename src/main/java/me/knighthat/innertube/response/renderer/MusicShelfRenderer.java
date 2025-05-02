package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;

import java.util.List;

public interface MusicShelfRenderer {

    Runs getTitle();

    List<Content> getContents();

    String getTrackingParams();

    Runs getBottomText();

    Endpoint getBottomEndpoint();

    ShelfDivider getShelfDivider();

    Boolean getContentsMultiSelectable();

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();
    }

    interface ShelfDivider {

        MusicShelfDividerRenderer getMusicShelfDividerRenderer();

        interface MusicShelfDividerRenderer {

            Boolean getHidden();
        }
    }
}