package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

public interface MusicTastebuilderShelfRenderer {

    Thumbnail getThumbnail();

    Runs getPrimaryText();

    Runs getSecondaryText();

    Button getButton();

    interface Thumbnail {

        MusicTastebuilderShelfThumbnailRenderer getMusicTastebuilderShelfThumbnailRenderer();

        interface MusicTastebuilderShelfThumbnailRenderer {

            Thumbnails getThumbnail();
        }
    }
}