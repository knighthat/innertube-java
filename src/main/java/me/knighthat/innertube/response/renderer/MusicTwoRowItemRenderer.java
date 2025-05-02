package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicTwoRowItemRenderer {

    Thumbnail getThumbnailRenderer();

    String getAspectRatio();

    Runs getTitle();

    Runs getSubtitle();

    Endpoint getNavigationEndpoint();

    String getTrackingParams();

    Menu getMenu();

    Overlay getThumbnailOverlay();

    List<Badge> getSubtitleBadges();
}