package me.knighthat.innertube;

import org.jetbrains.annotations.NotNull;

public interface PublicAccessible {

    @NotNull String getShareUrl();

    @NotNull String getYouTubeMusicShareUrl();
}
