package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.PlaylistPanelRenderer;

import java.util.List;

@Value
public class PlaylistPanelRendererImpl implements PlaylistPanelRenderer {

    List<ContentImpl>      contents;
    String                 playlistId;
    Boolean                isInfinite;
    List<ContinuationImpl> continuations;
    String                 trackingParams;
    Short                  numItemsToShow;
    ButtonImpl             shuffleToggleButton;

    @Value
    public static class ContentImpl implements Content {

        VideoRendererImpl               playlistPanelVideoRenderer;
        AutomixPreviewVideoRendererImpl automixPreviewVideoRenderer;

        @Value
        public static class VideoRendererImpl implements VideoRenderer {

            RunsImpl        title;
            RunsImpl        longBylineText;
            ThumbnailsImpl  thumbnail;
            RunsImpl        lengthText;
            Boolean         selected;
            EndpointImpl    navigationEndpoint;
            String          videoId;
            RunsImpl        shortBylineText;
            List<BadgeImpl> badges;
            String          trackingParams;
            MenuImpl        menu;
            String          playlistSetVideoId;
            Boolean         canReorder;
            EndpointImpl    queueNavigationEndpoint;
        }
    }
}