package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicCardShelfRenderer {

    String getTrackingParams();

    Thumbnail getThumbnail();

    Runs getTitle();

    Runs getSubtitle();

    List<Content> getContents();

    interface Content {

        MessageRenderer getMessageRenderer();

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        interface MessageRenderer {

            Runs getText();

            String getTrackingParams();

            Style getStyle();

            interface Style {

                String getValue();
            }
        }
    }
}