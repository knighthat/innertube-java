package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

public interface Accessibility {

    @NotNull
    Data getAccessibilityData();

    interface Data {

        @NotNull
        String getLabel();
    }
}
