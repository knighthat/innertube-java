package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.thumbnail.Thumbnails;

public interface NextResponse extends Trackable {

    @NotNull
    ResponseContext getResponseContext();

    @NotNull
    Contents getContents();

    @NotNull
    Endpoint getCurrentVideoEndpoint();

    @NotNull
    PlayerOverlays getPlayerOverlays();

    interface Contents {

        @Nullable
        SingleColumnMusicWatchNextResultsRenderer getSingleColumnMusicWatchNextResultsRenderer();

        @Nullable
        TwoColumnWatchNextResults getTwoColumnWatchNextResults();

        interface SingleColumnMusicWatchNextResultsRenderer {

            @NotNull
            TabbedRenderer getTabbedRenderer();

            interface TabbedRenderer {

                @NotNull
                Tabs getWatchNextTabbedResultsRenderer();
            }
        }

        interface TwoColumnWatchNextResults {

            @NotNull
            PrimaryResults getResults();
        }
    }

    interface PlayerOverlays {

        @NotNull
        PlayerOverlayRenderer getPlayerOverlayRenderer();

        interface PlayerOverlayRenderer {

            // Missing "actions"

            @NotNull
            BrowserMediaSession getBrowserMediaSession();

            interface BrowserMediaSession {

                @NotNull
                BrowserMediaSessionRenderer getBrowserMediaSessionRenderer();

                interface BrowserMediaSessionRenderer {

                    @NotNull
                    Runs getAlbum();

                    @NotNull
                    Thumbnails getThumbnailDetails();
                }
            }
        }
    }
}