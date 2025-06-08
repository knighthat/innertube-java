package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.NextResponse;

@Value
class NextResponseImpl implements NextResponse {

    ResponseContextImpl responseContext;
    ContentsImpl        contents;
    EndpointImpl        currentVideoEndpoint;
    String              trackingParams;
    PlayerOverlaysImpl  playerOverlays;

    @Value
    static class ContentsImpl implements Contents {

        SingleColumnMusicWatchNextResultsRendererImpl singleColumnMusicWatchNextResultsRenderer;

        TwoColumnWatchNextResultsImpl twoColumnWatchNextResults;

        @Value
        static class SingleColumnMusicWatchNextResultsRendererImpl implements SingleColumnMusicWatchNextResultsRenderer {

            TabbedRendererImpl tabbedRenderer;

            @Value
            static class TabbedRendererImpl implements TabbedRenderer {

                TabsImpl watchNextTabbedResultsRenderer;
            }
        }

        @Value
        static class TwoColumnWatchNextResultsImpl implements TwoColumnWatchNextResults {

            PrimaryResultsImpl results;
        }
    }

    @Value
    static class PlayerOverlaysImpl implements PlayerOverlays {

        PlayerOverlayRendererImpl playerOverlayRenderer;

        @Value
        static class PlayerOverlayRendererImpl implements PlayerOverlayRenderer {

            BrowserMediaSessionImpl browserMediaSession;

            @Value
            static class BrowserMediaSessionImpl implements BrowserMediaSession {

                BrowserMediaSessionRendererImpl browserMediaSessionRenderer;

                @Value
                static class BrowserMediaSessionRendererImpl implements BrowserMediaSessionRenderer {

                    RunsImpl       album;
                    ThumbnailsImpl thumbnailDetails;
                }
            }
        }
    }
}