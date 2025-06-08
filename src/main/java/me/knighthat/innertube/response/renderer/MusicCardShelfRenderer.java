package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Trackable;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicCardShelfRenderer extends Trackable {

    @NotNull
    Thumbnail getThumbnail();

    @NotNull
    Runs getTitle();

    @NotNull
    Runs getSubtitle();

    @NotNull
    List<? extends Content> getContents();

    interface Content {

        @NotNull
        MessageRenderer getMessageRenderer();

        @Nullable
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        interface MessageRenderer extends Trackable {

            @NotNull
            Runs getText();

            @Nullable
            Style getStyle();

            interface Style {

                String getValue();
            }
        }
    }
}