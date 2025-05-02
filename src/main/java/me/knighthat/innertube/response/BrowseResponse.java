package me.knighthat.innertube.response;

import me.knighthat.innertube.response.button.Button;
import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.menu.Menu;
import me.knighthat.innertube.response.renderer.SectionListRenderer;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface BrowseResponse {

    ResponseContext getResponseContext();

    Contents getContents();

    Header getHeader();

    // Missing "frameworkUpdates"

    String getTrackingParams();

    Integer getMaxAgeStoreSeconds();

    Microformat getMicroformat();

    Thumbnail getBackground();

    interface Contents {

        Tabs getSingleColumnBrowseResultsRenderer();

        TwoColumnBrowseResultsRenderer getTwoColumnBrowseResultsRenderer();

        SectionListRenderer getSectionListRenderer();

        interface TwoColumnBrowseResultsRenderer {

            List<Tabs.Tab> getTabs();

            SecondaryContents getSecondaryContents();

            interface SecondaryContents {

                SectionListRenderer getSectionListRenderer();
            }
        }
    }

    interface Header {

        MusicImmersiveHeaderRenderer getMusicImmersiveHeaderRenderer();

        MusicHeaderRenderer getMusicHeaderRenderer();

        interface MusicImmersiveHeaderRenderer {

            Runs getTitle();

            Runs getDescription();

            Button getMoreButton();

            Menu getMenu();

            Thumbnail getThumbnail();

            String getTrackingParams();

            Button getPlayButton();

            Button getStartRadioButton();

            Endpoint getShareEndpoint();

            Runs getMonthlyListenerCount();
        }

        interface MusicHeaderRenderer {

            Runs getTitle();

            String getTrackingParams();
        }
    }
}