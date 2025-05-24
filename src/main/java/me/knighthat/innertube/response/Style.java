package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Style {

    Integer getStartIndex();

    Integer getLength();

    Extension getStyleRunExtensions();

    String getFontFamilyName();

    interface Extension {

        @NotNull List<? extends Color> getColorMap();

        interface Color {

            String getKey();

            Long getValue();
        }
    }
}
