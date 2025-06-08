package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.NextResponse;

@Value
public class NextResponseImpl implements NextResponse {

    ResponseContextImpl responseContext;
    ContentsImpl        contents;
    EndpointImpl        currentVideoEndpoint;
    String              trackingParams;
    PlayerOverlaysImpl  playerOverlays;

    @Value
    public static class ContentsImpl implements Contents {

        SingleColumnMusicWatchNextResultsRendererImpl singleColumnMusicWatchNextResultsRenderer;

        TwoColumnWatchNextResultsImpl twoColumnWatchNextResults;

        @Value
        public static class SingleColumnMusicWatchNextResultsRendererImpl implements SingleColumnMusicWatchNextResultsRenderer {

            TabbedRendererImpl tabbedRenderer;

            @Value
            public static class TabbedRendererImpl implements TabbedRenderer {

                TabsImpl watchNextTabbedResultsRenderer;
            }
        }

        @Value
        public static class TwoColumnWatchNextResultsImpl implements TwoColumnWatchNextResults {

            PrimaryResultsImpl results;
        }
    }

    @Value
    public static class PlayerOverlaysImpl implements PlayerOverlays {

        PlayerOverlayRendererImpl playerOverlayRenderer;

        @Value
        public static class PlayerOverlayRendererImpl implements PlayerOverlayRenderer {

            BrowserMediaSessionImpl browserMediaSession;

            @Value
            public static class BrowserMediaSessionImpl implements BrowserMediaSession {

                BrowserMediaSessionRendererImpl browserMediaSessionRenderer;

                @Value
                public static class BrowserMediaSessionRendererImpl implements BrowserMediaSessionRenderer {

                    RunsImpl       album;
                    ThumbnailsImpl thumbnailDetails;
                }
            }
        }
    }
}