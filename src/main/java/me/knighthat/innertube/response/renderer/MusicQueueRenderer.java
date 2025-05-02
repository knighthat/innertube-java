package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Button;
import me.knighthat.innertube.response.Runs;

import java.util.List;

public interface MusicQueueRenderer {

    Content getContent();

    Boolean getHack();

    Header getHeader();

    SubHeaderChipCloud getSubHeaderChipCloud();

    interface Content {

        PlaylistPanelRenderer getPlaylistPanelRenderer();
    }

    interface Header {

        MusicQueueHeaderRenderer getMusicQueueHeaderRenderer();

        interface MusicQueueHeaderRenderer {

            Runs getTitle();

            Runs getSubtitle();

            List<Button> getButtons();

            String getTrackingParams();
        }
    }

    interface SubHeaderChipCloud {

        ChipCloudRenderer getChipCloudRenderer();
    }
}