package me.knighthat.innertube.response.button;

import me.knighthat.innertube.response.renderer.ChipCloudChipRenderer;

public interface Button {

    ButtonRenderer getButtonRenderer();

    ToggleButtonRenderer getToggleButtonRenderer();

    ChipCloudChipRenderer getChipCloudChipRenderer();

    LikeButtonRenderer getLikeButtonRenderer();
}