package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.Overlay;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.menu.Menu;
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