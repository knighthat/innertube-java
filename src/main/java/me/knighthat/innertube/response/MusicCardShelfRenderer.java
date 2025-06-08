package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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