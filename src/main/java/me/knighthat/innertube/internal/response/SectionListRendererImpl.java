package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SectionListRenderer;

import java.util.List;

@Value
public class SectionListRendererImpl implements SectionListRenderer {

    List<ContentImpl>      contents;
    List<ContinuationImpl> continuations;
    String                 trackingParams;
    HeaderImpl             header;

    @Value
    public static class ContentImpl implements Content {

        MusicDescriptionShelfRendererImpl  musicDescriptionShelfRenderer;
        MusicTastebuilderShelfRendererImpl musicTastebuilderShelfRenderer;
        MusicResponsiveHeaderRendererImpl  musicResponsiveHeaderRenderer;
        MusicShelfRendererImpl             musicShelfRenderer;
        MusicCarouselShelfRendererImpl     musicCarouselShelfRenderer;
        GridRendererImpl                   gridRenderer;
        MusicPlaylistShelfRendererImpl     musicPlaylistShelfRenderer;
        MusicCardShelfRendererImpl         musicCardShelfRenderer;

        @Value
        public static class MusicDescriptionShelfRendererImpl implements MusicDescriptionShelfRenderer {

            RunsImpl          description;
            ButtonImpl        moreButton;
            String            trackingParams;
            String            shelfStyle;
            Integer           maxCollapsedLines;
            Integer           maxExpandedLines;
            List<CommandImpl> onShowCommands;
            RunsImpl          footer;

            @Value
            public static class CommandImpl implements Command {

                String                   clickTrackingParams;
                LogLyricEventCommandImpl logLyricEventCommand;

                @Value
                public static class LogLyricEventCommandImpl implements LogLyricEventCommand {

                    String serializedLyricInfo;
                }
            }
        }

        @Value
        public static class MusicTastebuilderShelfRendererImpl implements MusicTastebuilderShelfRenderer {

            ThumbnailImpl thumbnail;
            RunsImpl      primaryText;
            RunsImpl      secondaryText;
            ButtonImpl    actionButton;
            Boolean       isVisible;
            String        trackingParams;

            @Value
            public static class ThumbnailImpl implements Thumbnail {

                MusicTastebuilderShelfThumbnailRendererImpl musicTastebuilderShelfThumbnailRenderer;

                @Value
                public static class MusicTastebuilderShelfThumbnailRendererImpl implements MusicTastebuilderShelfThumbnailRenderer {

                    ThumbnailsImpl thumbnail;
                }
            }
        }

        @Value
        public static class MusicResponsiveHeaderRendererImpl implements MusicResponsiveHeaderRenderer {

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
            public static class ButtonImpl implements Button {

                me.knighthat.innertube.internal.response.ButtonImpl.ToggleImpl    toggleButtonRenderer;
                me.knighthat.innertube.internal.response.ButtonImpl.MusicPlayImpl musicPlayButtonRenderer;
                MenuImpl.RendererImpl                                             menuRenderer;
            }

            @Value
            public static class DescriptionImpl implements Description {

                MusicDescriptionShelfRendererImpl musicDescriptionShelfRenderer;
            }
        }

        @Value
        public static class GridRendererImpl implements GridRenderer {

            List<ItemImpl> items;
            String         trackingParams;

            @Value
            public static class ItemImpl implements Item {

                MusicTwoRowItemRendererImpl musicTwoRowItemRenderer;
            }
        }
    }

    @Value
    public static class HeaderImpl implements Header {

        ChipCloudImpl chipCloudRenderer;
    }
}