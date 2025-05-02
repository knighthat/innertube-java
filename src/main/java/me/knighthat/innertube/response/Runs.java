package me.knighthat.innertube.response;

import me.knighthat.innertube.response.endpoint.Endpoint;

import java.util.List;

public interface Runs {

    List<Run> getRuns();

    Accessibility getAccessibility();

    interface Run {

        Boolean getBold();

        String getText();

        Endpoint getNavigationEndpoint();
    }
}