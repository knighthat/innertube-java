package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MusicCarouselShelfRenderer extends Trackable {

    @NotNull
    Header getHeader();

    @NotNull
    List<? extends Content> getContents();

    @NotNull
    String getItemSize();

    @NotNull
    String getNumItemsPerColumn();

    interface Header {

        @NotNull
        MusicCarouselShelfBasicHeaderRenderer getMusicCarouselShelfBasicHeaderRenderer();

        interface MusicCarouselShelfBasicHeaderRenderer extends Trackable {

            @NotNull
            Runs getTitle();

            @Nullable
            Runs getStrapline();

            @Nullable
            Accessibility getAccessibilityData();

            @NotNull
            String getHeaderStyle();

            @Nullable
            Button getMoreContentButton();
        }
    }

    interface Content {

        @Nullable
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        @Nullable
        MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
    }
}