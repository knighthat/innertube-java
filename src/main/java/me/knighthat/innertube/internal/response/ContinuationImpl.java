package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Continuation;

@Value
class ContinuationImpl implements Continuation {

    DataImpl nextContinuationData;
    DataImpl nextRadioContinuationData;

    @lombok.Data
    static class DataImpl implements Data {

        String continuation;
        String clickTrackingParams;
    }
}
