package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Thumbnails;

import java.util.List;

@Value
public class ThumbnailsImpl implements Thumbnails {

    List<ThumbnailImpl> thumbnails;

    @Value
    public static class ThumbnailImpl implements Thumbnail {

        String url;
        Short  width;
        Short  height;
    }
}