package me.knighthat.innertube.model;

import org.jetbrains.annotations.NotNull;

public interface Identifiable {

    @NotNull String getId();

    @NotNull String getName();
}
