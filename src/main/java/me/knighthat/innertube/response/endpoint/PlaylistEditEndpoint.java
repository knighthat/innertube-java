package me.knighthat.innertube.response.endpoint;

import java.util.List;

public interface PlaylistEditEndpoint {

    String getPlaylistId();

    List<Action> getActions();

    interface Action {

        String getSetVideoId();

        String getAction();

        String getRemovedVideoId();
    }
}