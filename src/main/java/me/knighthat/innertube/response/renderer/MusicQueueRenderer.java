package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.Button;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Trackable;

import java.util.List;

public interface MusicQueueRenderer {

    @NotNull
    Content getContent();

    @NotNull
    Boolean getHack();

    @NotNull
    Header getHeader();

    @Nullable
    SubHeaderChipCloud getSubHeaderChipCloud();

    interface Content {

        @NotNull
        PlaylistPanelRenderer getPlaylistPanelRenderer();
    }

    interface Header {

        @NotNull
        MusicQueueHeaderRenderer getMusicQueueHeaderRenderer();

        interface MusicQueueHeaderRenderer extends Trackable {

            @NotNull
            Runs getTitle();

            @NotNull
            Runs getSubtitle();

            @NotNull
            List<? extends Button> getButtons();
        }
    }

    interface SubHeaderChipCloud {

        @NotNull
        ChipCloud getChipCloudRenderer();
    }
}