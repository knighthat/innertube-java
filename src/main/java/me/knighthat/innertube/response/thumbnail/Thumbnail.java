package me.knighthat.innertube.response.thumbnail;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.Trackable;

public interface Thumbnail {

    @NotNull
    Renderer getMusicThumbnailRenderer();

    interface Renderer extends Trackable {

        @NotNull
        Thumbnails getThumbnail();

        @Nullable
        String getThumbnailCrop();

        @Nullable
        String getThumbnailScale();
    }
}