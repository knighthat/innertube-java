package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Style;

import java.util.List;

@Value
class StyleImpl implements Style {

    Integer          startIndex;
    Integer          length;
    RunExtensionImpl styleRunExtensions;
    String           fontFamilyName;

    @Value
    static class RunExtensionImpl implements RunExtension {

        ColorMapExtensionImpl styleRunColorMapExtension;

        @Value
        static class ColorMapExtensionImpl implements ColorMapExtension {

            List<ColorImpl> colorMap;

            @Value
            static class ColorImpl implements ColorMap {

                String key;
                Long   value;
            }
        }
    }
}
