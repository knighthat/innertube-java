package me.knighthat.innertube.response;

import java.util.List;

public interface Runs {

    List<? extends Run> getRuns();

    Accessibility getAccessibility();

    interface Run {

        Boolean getBold();

        String getText();

        Endpoint getNavigationEndpoint();
    }
}