package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicPlaylistShelfRenderer;

import java.util.List;

@Value
class MusicPlaylistShelfRendererImpl implements MusicPlaylistShelfRenderer {

    String            playlistId;
    List<ContentImpl> contents;
    Integer           collapsedItemCount;
    String            trackingParams;
    Boolean           contentsMultiSelectable;
    String            targetId;

    @Value
    static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
        ContinuationItemRendererImpl continuationItemRenderer;

        @Value
        static class ContinuationItemRendererImpl implements ContinuationItemRenderer {

            String           trigger;
            ContinuationImpl continuationEndpoint;

            @Value
            static class ContinuationImpl implements Continuation {

                CommandImpl continuationCommand;
                String      clickTrackingParams;

                @Value
                static class CommandImpl implements Command {

                    String token;
                    String request;
                }
            }
        }
    }
}