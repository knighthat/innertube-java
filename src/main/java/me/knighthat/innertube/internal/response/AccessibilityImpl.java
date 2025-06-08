package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Accessibility;

@Value
class AccessibilityImpl implements Accessibility {

    DataImpl accessibilityData;

    @lombok.Data
    static class DataImpl implements Data {

        String label;
    }
}
