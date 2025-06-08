package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;
import me.knighthat.innertube.response.thumbnail.Thumbnails;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface SectionListRenderer extends Trackable {

    @NotNull
    List<? extends Content> getContents();

    @NotNull
    List<? extends Continuation> getContinuations();

    @Nullable
    Header getHeader();

    interface Content {

        @Nullable
        MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();

        @Nullable
        MusicTastebuilderShelfRenderer getMusicTastebuilderShelfRenderer();

        @Nullable
        MusicResponsiveHeaderRenderer getMusicResponsiveHeaderRenderer();

        @Nullable
        MusicShelfRenderer getMusicShelfRenderer();

        @Nullable
        MusicCarouselShelfRenderer getMusicCarouselShelfRenderer();

        @Nullable
        GridRenderer getGridRenderer();

        @Nullable
        MusicPlaylistShelfRenderer getMusicPlaylistShelfRenderer();

        @Nullable
        MusicCardShelfRenderer getMusicCardShelfRenderer();

        interface MusicDescriptionShelfRenderer extends Trackable {

            @NotNull
            Runs getDescription();

            @Nullable
            Button getMoreButton();

            @Nullable
            String getShelfStyle();

            @Nullable
            Integer getMaxCollapsedLines();

            @Nullable
            Integer getMaxExpandedLines();

            @NotNull
            List<? extends Command> getOnShowCommands();

            @Nullable
            Runs getFooter();

            interface Command extends ClickTrackable {

                @NotNull
                LogLyricEventCommand getLogLyricEventCommand();

                interface LogLyricEventCommand {

                    @NotNull
                    String getSerializedLyricInfo();
                }
            }
        }

        interface MusicTastebuilderShelfRenderer extends Trackable {

            @NotNull
            Thumbnail getThumbnail();

            @NotNull
            Runs getPrimaryText();

            @NotNull
            Runs getSecondaryText();

            @Nullable
            Button getActionButton();

            @Nullable
            Boolean getIsVisible();

            interface Thumbnail {

                @NotNull
                MusicTastebuilderShelfThumbnailRenderer getMusicTastebuilderShelfThumbnailRenderer();

                interface MusicTastebuilderShelfThumbnailRenderer {

                    @NotNull
                    Thumbnails getThumbnail();
                }
            }
        }

        interface MusicResponsiveHeaderRenderer extends Trackable {

            @NotNull
            Thumbnail getThumbnail();

            @NotNull
            List<? extends Button> getButtons();

            @NotNull
            Runs getTitle();

            @NotNull
            Runs getSubtitle();

            @NotNull
            Description getDescription();

            @Nullable
            Runs getStraplineTextOne();

            @Nullable
            Thumbnail getStraplineThumbnail();

            @NotNull
            List<? extends Badge> getSubtitleBadge();

            Runs getSecondSubtitle();

            interface Button {

                @Nullable
                me.knighthat.innertube.response.Button.Toggle getToggleButtonRenderer();

                @Nullable
                me.knighthat.innertube.response.Button.MusicPlay getMusicPlayButtonRenderer();

                @Nullable
                Menu.Renderer getMenuRenderer();
            }

            interface Description {

                @NotNull
                MusicDescriptionShelfRenderer getMusicDescriptionShelfRenderer();
            }
        }

        interface GridRenderer extends Trackable {

            @NotNull
            List<? extends Item> getItems();

            interface Item {

                @NotNull
                MusicTwoRowItemRenderer getMusicTwoRowItemRenderer();
            }
        }
    }

    interface Header {

        @NotNull
        ChipCloud getChipCloudRenderer();
    }
}