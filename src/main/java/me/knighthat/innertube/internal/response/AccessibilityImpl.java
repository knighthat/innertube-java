package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Accessibility;

@Value
public class AccessibilityImpl implements Accessibility {

    DataImpl accessibilityData;

    @lombok.Data
    public static class DataImpl implements Data {

        String label;
    }
}
