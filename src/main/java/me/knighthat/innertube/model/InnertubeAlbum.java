package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.Thumbnails;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Value
public class InnertubeAlbum implements Identifiable, Visual {

    @NotNull
    String id;

    @NotNull
    String name;

    @NotNull
    @Unmodifiable
    List<Thumbnails.Thumbnail> thumbnails;

    /**
     * Release year
     * <p>
     * Returns empty string if unknown
     */
    @NotNull
    String year;

    /**
     * Whether song is appropriate for all listeners
     * <p>
     * Returns {@code false} if unknown
     */
    boolean explicit;

    public InnertubeAlbum( @NotNull MusicTwoRowItemRenderer renderer ) {
        Runs.Run run = Objects.requireNonNull(
                renderer.getTitle()
                        .getRuns()
                        .getFirst()
        );

        this.id = Objects.requireNonNull(
                run.getNavigationEndpoint()
                   .getBrowseEndpoint()
                   .getBrowseId()
        );
        this.name = run.getText();
        this.thumbnails = Collections.unmodifiableList(
                renderer.getThumbnailRenderer()
                        .getMusicThumbnailRenderer()
                        .getThumbnail()
                        .getThumbnails()
        );
        String year = ItemUtils.getFirstText( renderer.getSubtitle() );
        if ( !year.matches( "\\d{4}" ) )
            year = "";
        this.year = year;
        this.explicit = ItemUtils.containsExplicitBadge( renderer.getSubtitleBadges() );
    }
}
