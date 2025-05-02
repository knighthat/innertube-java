package me.knighthat.innertube.response;

public interface Continuation {

    NextContinuationData getNextContinuationData();

    NextContinuationData getNextRadioContinuationData();

    interface NextContinuationData {

        String getContinuation();

        String getClickTrackingParams();
    }
}
