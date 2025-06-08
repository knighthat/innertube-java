package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Runs {

    @NotNull
    List<? extends Run> getRuns();

    @Nullable
    Accessibility getAccessibility();

    interface Run {

        @Nullable
        Boolean getBold();

        @NotNull
        String getText();

        @Nullable
        Endpoint getNavigationEndpoint();
    }
}