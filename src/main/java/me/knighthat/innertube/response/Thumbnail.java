package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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