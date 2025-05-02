package me.knighthat.innertube.response;

public interface Continuation {

    Data getNextContinuationData();

    Data getNextRadioContinuationData();

    interface Data {

        String getContinuation();

        String getClickTrackingParams();
    }
}
