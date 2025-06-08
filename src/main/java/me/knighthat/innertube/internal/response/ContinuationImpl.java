package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Continuation;

@Value
public class ContinuationImpl implements Continuation {

    DataImpl nextContinuationData;
    DataImpl nextRadioContinuationData;

    @lombok.Data
    public static class DataImpl implements Data {

        String continuation;
        String clickTrackingParams;
    }
}
