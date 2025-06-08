package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Style;

import java.util.List;

@Value
public class StyleImpl implements Style {

    Integer          startIndex;
    Integer          length;
    RunExtensionImpl styleRunExtensions;
    String           fontFamilyName;

    @Value
    public static class RunExtensionImpl implements RunExtension {

        ColorMapExtensionImpl styleRunColorMapExtension;

        @Value
        public static class ColorMapExtensionImpl implements ColorMapExtension {

            List<ColorImpl> colorMap;

            @Value
            public static class ColorImpl implements ColorMap {

                String key;
                Long   value;
            }
        }
    }
}
