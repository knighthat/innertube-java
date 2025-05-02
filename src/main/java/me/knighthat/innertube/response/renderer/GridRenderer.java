package me.knighthat.innertube.response.renderer;

import java.util.List;

public interface GridRenderer {

    List<Item> getItems();

    String getTrackingParams();

    interface Item {

        MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
    }
}