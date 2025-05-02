package me.knighthat.innertube.response.button;

import me.knighthat.innertube.response.endpoint.Endpoint;

public interface LikeButtonRenderer {

    Target getTarget();

    String getLikeStatus();

    String getTrackingParams();

    Boolean getLikesAllowed();

    Endpoint getDislikeNavigationEndpoint();

    Endpoint getLikeCommand();

    interface Target {

        String getVideoId();
    }
}