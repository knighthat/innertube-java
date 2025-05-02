package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;

import java.util.List;

public interface MusicDescriptionShelfRenderer {

    Runs getDescription();

    Button getMoreButton();

    String getTrackingParams();

    String getShelfStyle();

    Integer getMaxCollapsedLines();

    Integer getMaxExpandedLines();

    List<Command> getOnShowCommands();

    Runs getFooter();

    interface Command {

        String getClickTrackingParams();

        LogLyricEventCommand getLogLyricEventCommand();

        interface LogLyricEventCommand {

            String getSerializedLyricInfo();
        }
    }
}