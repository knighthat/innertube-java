package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Continuation {

    @Nullable
    Data getNextContinuationData();

    @Nullable
    Data getNextRadioContinuationData();

    interface Data extends ClickTrackable {

        @NotNull
        String getContinuation();
    }
}
