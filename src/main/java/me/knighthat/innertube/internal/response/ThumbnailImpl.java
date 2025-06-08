package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Thumbnail;

@Value
public class ThumbnailImpl implements Thumbnail {

    RendererImpl musicThumbnailRenderer;

    @Value
    public static class RendererImpl implements Renderer {

        ThumbnailsImpl thumbnail;
        String         thumbnailCrop;
        String         thumbnailScale;
        String         trackingParams;
    }
}