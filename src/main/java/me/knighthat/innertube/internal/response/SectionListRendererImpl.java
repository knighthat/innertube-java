package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SectionListRenderer;

import java.util.List;

@Value
class SectionListRendererImpl implements SectionListRenderer {

    List<ContentImpl>      contents;
    List<ContinuationImpl> continuations;
    String                 trackingParams;
    HeaderImpl             header;

    @Value
    static class ContentImpl implements Content {

        MusicDescriptionShelfRendererImpl  musicDescriptionShelfRenderer;
        MusicTastebuilderShelfRendererImpl musicTastebuilderShelfRenderer;
        MusicResponsiveHeaderRendererImpl  musicResponsiveHeaderRenderer;
        MusicShelfRendererImpl             musicShelfRenderer;
        MusicCarouselShelfRendererImpl     musicCarouselShelfRenderer;
        GridRendererImpl                   gridRenderer;
        MusicPlaylistShelfRendererImpl     musicPlaylistShelfRenderer;
        MusicCardShelfRendererImpl         musicCardShelfRenderer;

        @Value
        static class MusicDescriptionShelfRendererImpl implements MusicDescriptionShelfRenderer {

            RunsImpl          description;
            ButtonImpl        moreButton;
            String            trackingParams;
            String            shelfStyle;
            Integer           maxCollapsedLines;
            Integer           maxExpandedLines;
            List<CommandImpl> onShowCommands;
            RunsImpl          footer;

            @Value
            static class CommandImpl implements Command {

                String                   clickTrackingParams;
                LogLyricEventCommandImpl logLyricEventCommand;

                @Value
                static class LogLyricEventCommandImpl implements LogLyricEventCommand {

                    String serializedLyricInfo;
                }
            }
        }

        @Value
        static class MusicTastebuilderShelfRendererImpl implements MusicTastebuilderShelfRenderer {

            ThumbnailImpl thumbnail;
            RunsImpl      primaryText;
            RunsImpl      secondaryText;
            ButtonImpl    actionButton;
            Boolean       isVisible;
            String        trackingParams;

            @Value
            static class ThumbnailImpl implements Thumbnail {

                MusicTastebuilderShelfThumbnailRendererImpl musicTastebuilderShelfThumbnailRenderer;

                @Value
                static class MusicTastebuilderShelfThumbnailRendererImpl implements MusicTastebuilderShelfThumbnailRenderer {

                    ThumbnailsImpl thumbnail;
                }
            }
        }

        @Value
        static class MusicResponsiveHeaderRendererImpl implements MusicResponsiveHeaderRenderer {

            ThumbnailImpl    thumbnail;
            List<ButtonImpl> buttons;
            RunsImpl         title;
            RunsImpl         subtitle;
            String           trackingParams;
            DescriptionImpl  description;
            RunsImpl         straplineTextOne;
            ThumbnailImpl    straplineThumbnail;
            List<BadgeImpl>  subtitleBadge;
            RunsImpl         secondSubtitle;

            @Value
            static class ButtonImpl implements Button {

                me.knighthat.innertube.internal.response.ButtonImpl.ToggleImpl    toggleButtonRenderer;
                me.knighthat.innertube.internal.response.ButtonImpl.MusicPlayImpl musicPlayButtonRenderer;
                MenuImpl.RendererImpl                                             menuRenderer;
            }

            @Value
            static class DescriptionImpl implements Description {

                MusicDescriptionShelfRendererImpl musicDescriptionShelfRenderer;
            }
        }

        @Value
        static class GridRendererImpl implements GridRenderer {

            List<ItemImpl> items;
            String         trackingParams;

            @Value
            static class ItemImpl implements Item {

                MusicTwoRowItemRendererImpl musicTwoRowItemRenderer;
            }
        }
    }

    @Value
    static class HeaderImpl implements Header {

        ChipCloudImpl chipCloudRenderer;
    }
}