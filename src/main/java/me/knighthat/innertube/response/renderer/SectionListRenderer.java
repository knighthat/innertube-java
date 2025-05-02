package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Continuation;

import java.util.List;

public interface SectionListRenderer {

    List<Content> getContents();

    List<Continuation> getContinuations();

    String getTrackingParams();

    Header getHeader();

    interface Content {

        MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();

        MusicTastebuilderShelfRenderer getMusicTastebuilderShelfRenderer();

        MusicResponsiveHeaderRenderer getMusicResponsiveHeaderRenderer();

        MusicShelfRenderer getMusicShelfRenderer();

        MusicCarouselShelfRenderer getMusicCarouselShelfRenderer();

        GridRenderer getGridRenderer();

        MusicPlaylistShelfRenderer getMusicPlaylistShelfRenderer();

        MusicCardShelfRenderer getMusicCardShelfRenderer();
    }

    interface Header {

        ChipCloudRenderer getChipCloudRenderer();
    }
}