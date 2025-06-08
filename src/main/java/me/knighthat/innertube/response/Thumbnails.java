package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Thumbnails {

    @NotNull
    List<? extends Thumbnail> getThumbnails();

    interface Thumbnail {

        @NotNull
        String getUrl();

        @NotNull
        Short getWidth();

        @NotNull
        Short getHeight();
    }
}