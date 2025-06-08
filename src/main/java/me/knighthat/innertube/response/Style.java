package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Style {

    Integer getStartIndex();

    Integer getLength();

    RunExtension getStyleRunExtensions();

    String getFontFamilyName();

    interface RunExtension {

        @NotNull
        ColorMapExtension getStyleRunColorMapExtension();

        interface ColorMapExtension {

            @NotNull
            List<? extends ColorMap> getColorMap();

            interface ColorMap {

                @NotNull
                String getKey();

                @NotNull
                Long getValue();
            }
        }
    }
}
