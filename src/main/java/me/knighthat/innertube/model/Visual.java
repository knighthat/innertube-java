package me.knighthat.innertube.model;

import me.knighthat.innertube.response.Thumbnails;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public interface Visual {

    /**
     * A set of thumbnails, variable in sizes
     */
    @Unmodifiable
    @NotNull
    List<Thumbnails.Thumbnail> getThumbnails();
}
