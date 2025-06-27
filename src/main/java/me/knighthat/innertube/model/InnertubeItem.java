package me.knighthat.innertube.model;

import lombok.Getter;
import me.knighthat.innertube.response.Endpoint;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Thumbnails;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
public abstract class InnertubeItem {

    @NotNull
    String id;

    @NotNull
    String name;

    @NotNull
    @Unmodifiable
    List<Thumbnails.Thumbnail> thumbnails;

    protected InnertubeItem(
            @NotNull String id,
            @NotNull String name,
            @NotNull List<? extends Thumbnails.Thumbnail> thumbnails
    ) {
        this.id = id;
        this.name = name;
        this.thumbnails = Collections.unmodifiableList( thumbnails );
    }

    protected InnertubeItem( @NotNull MusicTwoRowItemRenderer renderer ) {
        Runs.Run run = Objects.requireNonNull(
                renderer.getTitle()
                        .getRuns()
                        .get( 0 )
        );

        Endpoint navigationEndpoint = Objects.requireNonNull( run.getNavigationEndpoint() );
        this.id = Objects.requireNonNull(
                navigationEndpoint.getBrowseEndpoint()
        ).getBrowseId();
        this.name = run.getText();
        this.thumbnails = ItemUtils.extractThumbnail( renderer.getThumbnailRenderer() );
    }
}
