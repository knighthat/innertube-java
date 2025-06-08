package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface PlaylistPanelRenderer extends Trackable {

    @NotNull
    List<? extends Content> getContents();

    @NotNull
    String getPlaylistId();

    @NotNull
    Boolean getIsInfinite();

    @NotNull
    List<? extends Continuation> getContinuations();

    @NotNull
    Short getNumItemsToShow();

    @Nullable
    Button getShuffleToggleButton();

    interface Content {

        @Nullable
        VideoRenderer getPlaylistPanelVideoRenderer();

        @Nullable
        AutomixPreviewVideoRenderer getAutomixPreviewVideoRenderer();

        interface VideoRenderer extends Trackable {

            @NotNull
            Runs getTitle();

            @NotNull
            Runs getLongBylineText();

            @NotNull
            Thumbnails getThumbnail();

            @NotNull
            Runs getLengthText();

            @NotNull
            Boolean getSelected();

            @NotNull
            Endpoint getNavigationEndpoint();

            @NotNull
            String getVideoId();

            @NotNull
            Runs getShortBylineText();

            @NotNull
            List<? extends Badge> getBadges();

            @Nullable
            Menu getMenu();

            @NotNull
            String getPlaylistSetVideoId();

            @NotNull
            Boolean getCanReorder();

            @Nullable
            Endpoint getQueueNavigationEndpoint();
        }
    }
}