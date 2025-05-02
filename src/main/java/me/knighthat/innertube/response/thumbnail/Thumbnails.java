package me.knighthat.innertube.response.thumbnail;

import java.util.List;

public interface Thumbnails {

    List<? extends Thumbnail> getThumbnails();

    interface Thumbnail {

        String getUrl();

        Short getWidth();

        Short getHeight();
    }
}