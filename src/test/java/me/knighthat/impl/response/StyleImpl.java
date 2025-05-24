package me.knighthat.impl.response;

import lombok.Data;
import me.knighthat.innertube.response.Style;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class StyleImpl implements Style {

    private final Integer       startIndex;
    private final Integer       length;
    private final ExtensionImpl styleRunExtensions;
    private final String        fontFamilyName;

    @Data
    public static class ExtensionImpl implements Extension {

        @NotNull
        private final List<ColorImpl> colorMap;

        @Data
        public static class ColorImpl implements Color {

            private final String key;
            private final Long   value;
        }
    }
}
