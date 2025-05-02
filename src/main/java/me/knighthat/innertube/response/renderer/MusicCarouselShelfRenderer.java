package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;

import java.util.List;

public interface MusicCarouselShelfRenderer {

    Header getHeader();

    List<Content> getContents();

    String getTrackingParams();

    String getItemSize();

    String getNumItemsPerColumn();

    interface Header {

        MusicCarouselShelfBasicHeaderRenderer getMusicCarouselShelfBasicHeaderRenderer();

        interface MusicCarouselShelfBasicHeaderRenderer {

            Runs getTitle();

            Accessibility getAccessibilityData();

            String getHeaderStyle();

            Button getMoreContentButton();

            String getTrackingParams();
        }
    }

    interface Content {

        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
    }
}