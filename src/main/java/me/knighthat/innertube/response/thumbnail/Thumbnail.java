package me.knighthat.innertube.response.thumbnail;

public interface Thumbnail {

    Renderer getMusicThumbnailRenderer();

    interface Renderer {

        Thumbnails getThumbnail();

        String getThumbnailCrop();

        String getThumbnailScale();

        String getTrackingParams();
    }
}