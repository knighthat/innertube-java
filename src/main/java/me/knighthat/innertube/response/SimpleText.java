package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SimpleText {

    @NotNull
    String getSimpleText();

    @Nullable
    Accessibility getAccessibility();
}