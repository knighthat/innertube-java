package me.knighthat.innertube.response.renderer;

import java.util.List;

public interface ChipCloudRenderer {

    List<Chip> getChips();

    interface Chip {

        ChipCloudChipRenderer getChipCloudChipRenderer();
    }
}