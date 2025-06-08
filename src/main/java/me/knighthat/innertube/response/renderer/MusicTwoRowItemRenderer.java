package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicTwoRowItemRenderer extends Trackable {

    @NotNull
    Thumbnail getThumbnailRenderer();

    @NotNull
    String getAspectRatio();

    @NotNull
    Runs getTitle();

    @NotNull
    Runs getSubtitle();

    @NotNull
    Endpoint getNavigationEndpoint();

    @Nullable
    Menu getMenu();

    @Nullable
    Overlay getThumbnailOverlay();

    @NotNull
    List<? extends Badge> getSubtitleBadges();
}