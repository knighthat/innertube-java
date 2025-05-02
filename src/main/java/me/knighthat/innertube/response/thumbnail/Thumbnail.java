package me.knighthat.innertube.response.thumbnail;

public interface Thumbnail {

    MusicThumbnailRenderer getMusicThumbnailRenderer();

    interface MusicThumbnailRenderer {

        Thumbnails getThumbnail();

        String getThumbnailCrop();

        String getThumbnailScale();

        String getTrackingParams();
    }
}