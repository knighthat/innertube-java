package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;

import java.util.List;

@Value
class MusicTwoRowItemRendererImpl implements MusicTwoRowItemRenderer {

    ThumbnailImpl   thumbnailRenderer;
    String          aspectRatio;
    RunsImpl        title;
    RunsImpl        subtitle;
    EndpointImpl    navigationEndpoint;
    String          trackingParams;
    MenuImpl        menu;
    OverlayImpl     thumbnailOverlay;
    List<BadgeImpl> subtitleBadges;
}