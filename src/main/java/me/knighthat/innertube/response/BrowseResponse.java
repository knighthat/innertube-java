package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.renderer.SectionListRenderer;
import me.knighthat.innertube.response.thumbnail.Thumbnail;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface BrowseResponse extends Trackable, InnerTubeResponse {

    @NotNull
    ResponseContext getResponseContext();

    @NotNull
    Contents getContents();

    @Nullable
    Header getHeader();

    // Missing "frameworkUpdates"

    @Nullable
    Integer getMaxAgeStoreSeconds();

    @Nullable
    Microformat getMicroformat();

    @Nullable
    Thumbnail getBackground();

    interface Contents {

        @Nullable
        Tabs getSingleColumnBrowseResultsRenderer();

        @Nullable
        TwoColumnBrowseResultsRenderer getTwoColumnBrowseResultsRenderer();

        @Nullable
        SectionListRenderer getSectionListRenderer();

        interface TwoColumnBrowseResultsRenderer {

            @NotNull
            List<? extends Tabs.Tab> getTabs();

            @Nullable
            SecondaryContents getSecondaryContents();

            interface SecondaryContents {

                @NotNull
                SectionListRenderer getSectionListRenderer();
            }
        }
    }

    interface Header {

        @Nullable
        MusicImmersiveHeaderRenderer getMusicImmersiveHeaderRenderer();

        @Nullable
        MusicHeaderRenderer getMusicHeaderRenderer();

        interface MusicImmersiveHeaderRenderer extends Trackable {

            @NotNull
            Runs getTitle();

            @NotNull
            Button getSubscriptionButton();

            @NotNull
            Runs getDescription();

            @Nullable
            Button getMoreButton();

            @Nullable
            Menu getMenu();

            @NotNull
            Thumbnail getThumbnail();

            @Nullable
            Button getPlayButton();

            @Nullable
            Button getStartRadioButton();

            @Nullable
            Endpoint getShareEndpoint();

            @NotNull
            Runs getMonthlyListenerCount();
        }

        interface MusicHeaderRenderer extends Trackable {

            @NotNull
            Runs getTitle();
        }
    }
}