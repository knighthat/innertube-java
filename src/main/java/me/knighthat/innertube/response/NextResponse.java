package me.knighthat.innertube.response;

import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.thumbnail.Thumbnails;

public interface NextResponse {

    ResponseContext getResponseContext();

    Contents getContents();

    Endpoint getCurrentVideoEndpoint();

    String getTrackingParams();

    PlayerOverlays getPlayerOverlays();

    interface Contents {

        SingleColumnMusicWatchNextResultsRenderer getSingleColumnMusicWatchNextResultsRenderer();

        interface SingleColumnMusicWatchNextResultsRenderer {

            TabbedRenderer getTabbedRenderer();

            interface TabbedRenderer {

                Tabs getWatchNextTabbedResultsRenderer();
            }
        }
    }

    interface PlayerOverlays {

        PlayerOverlayRenderer getPlayerOverlayRenderer();

        interface PlayerOverlayRenderer {

            // Missing "actions"

            BrowserMediaSession getBrowserMediaSession();

            interface BrowserMediaSession {

                BrowserMediaSessionRenderer getBrowserMediaSessionRenderer();

                interface BrowserMediaSessionRenderer {

                    Runs getAlbum();

                    Thumbnails getThumbnailDetails();
                }
            }
        }
    }
}