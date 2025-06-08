package me.knighthat.impl.response;

import java.util.List;

import lombok.Data;
import me.knighthat.innertube.response.Style;

@Data
public class StyleImpl implements Style {

    private final Integer          startIndex;
    private final Integer          length;
    private final RunExtensionImpl styleRunExtensions;
    private final String           fontFamilyName;

    @Data
    public static class RunExtensionImpl implements RunExtension {

        private final ColorMapExtensionImpl styleRunColorMapExtension;

        @Data
        public static class ColorMapExtensionImpl implements ColorMapExtension {

            private final List<ColorImpl> colorMap;

            @Data
            public static class ColorImpl implements ColorMap {

                private final String key;
                private final Long   value;
            }
        }
    }
}
