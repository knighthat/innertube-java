package me.knighthat.innertube.response.endpoint;

public interface LikeEndpoint {

    String getStatus();

    Target getTarget();

    interface Target {

        String getPlaylistId();
    }
}