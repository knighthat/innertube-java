package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

import java.util.List;

public interface SectionListRenderer {

    List<? extends Content> getContents();

    List<? extends Continuation> getContinuations();

    String getTrackingParams();

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

        interface MusicDescriptionShelfRenderer {

            Runs getDescription();

            Button getMoreButton();

            String getTrackingParams();

            String getShelfStyle();

            Integer getMaxCollapsedLines();

            Integer getMaxExpandedLines();

            List<? extends Command> getOnShowCommands();

            Runs getFooter();

            interface Command {

                String getClickTrackingParams();

                LogLyricEventCommand getLogLyricEventCommand();

                interface LogLyricEventCommand {

                    String getSerializedLyricInfo();
                }
            }
        }

        interface MusicTastebuilderShelfRenderer {

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

        interface MusicResponsiveHeaderRenderer {

            Thumbnail getThumbnail();

            List<? extends Button> getButtons();

            Runs getTitle();

            Runs getSubtitle();

            String getTrackingParams();

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

        interface GridRenderer {

            List<? extends Item> getItems();

            String getTrackingParams();

            interface Item {

                MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
            }
        }
    }

    interface Header {

        ChipCloud getChipCloudRenderer();
    }
}