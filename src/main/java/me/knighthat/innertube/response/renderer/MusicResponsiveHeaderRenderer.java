package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.MusicPlayButtonRenderer;
import me.knighthat.innertube.response.button.ToggleButtonRenderer;
import me.knighthat.innertube.response.menu.MenuRenderer;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicResponsiveHeaderRenderer {

    Thumbnail getThumbnail();

    List<Button> getButtons();

    Runs getTitle();

    Runs getSubtitle();

    String getTrackingParams();

    Description getDescription();

    Runs getStraplineTextOne();

    Thumbnail getStraplineThumbnail();

    List<Badge> getSubtitleBadge();

    Runs getSecondSubtitle();

    interface Button {

        ToggleButtonRenderer getToggleButtonRenderer();

        MusicPlayButtonRenderer getMusicPlayButtonRenderer();

        MenuRenderer getMenuRenderer();
    }

    interface Description {

        MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();
    }
}