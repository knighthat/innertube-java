package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

import java.util.List;

public interface SectionListRenderer extends Trackable{

    List<? extends Content> getContents();

    List<? extends Continuation> getContinuations();

    Header getHeader();

    interface Content {

        MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();

        MusicTastebuilderShelfRenderer getMusicTastebuilderShelfRenderer();

        MusicResponsiveHeaderRenderer getMusicResponsiveHeaderRenderer();

        MusicShelfRenderer getMusicShelfRenderer();

        MusicCarouselShelfRenderer getMusicCarouselShelfRenderer();

        GridRenderer getGridRenderer();

        MusicPlaylistShelfRenderer getMusicPlaylistShelfRenderer();

        MusicCardShelfRenderer getMusicCardShelfRenderer();

        interface MusicDescriptionShelfRenderer extends Trackable {

            Runs getDescription();

            Button getMoreButton();

            String getShelfStyle();

            Integer getMaxCollapsedLines();

            Integer getMaxExpandedLines();

            List<? extends Command> getOnShowCommands();

            Runs getFooter();

            interface Command extends ClickTrackable {

                LogLyricEventCommand getLogLyricEventCommand();

                interface LogLyricEventCommand {

                    String getSerializedLyricInfo();
                }
            }
        }

        interface MusicTastebuilderShelfRenderer extends Trackable {

            Thumbnail getThumbnail();

            Runs getPrimaryText();

            Runs getSecondaryText();

            Button getActionButton();

            Boolean getIsVisible();

            interface Thumbnail {

                MusicTastebuilderShelfThumbnailRenderer getMusicTastebuilderShelfThumbnailRenderer();

                interface MusicTastebuilderShelfThumbnailRenderer {

                    Thumbnails getThumbnail();
                }
            }
        }

        interface MusicResponsiveHeaderRenderer extends Trackable {

            Thumbnail getThumbnail();

            List<? extends Button> getButtons();

            Runs getTitle();

            Runs getSubtitle();

            Description getDescription();

            Runs getStraplineTextOne();

            Thumbnail getStraplineThumbnail();

            List<? extends Badge> getSubtitleBadge();

            Runs getSecondSubtitle();

            interface Button {

                me.knighthat.innertube.response.Button.Toggle getToggleButtonRenderer();

                me.knighthat.innertube.response.Button.MusicPlay getMusicPlayButtonRenderer();

                Menu.Renderer getMenuRenderer();
            }

            interface Description {

                MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();
            }
        }

        interface GridRenderer extends Trackable {

            List<? extends Item> getItems();

            interface Item {

                MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
            }
        }
    }

    interface Header {

        ChipCloud getChipCloudRenderer();
    }
}