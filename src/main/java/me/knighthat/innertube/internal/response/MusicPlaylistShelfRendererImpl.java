package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicPlaylistShelfRenderer;

import java.util.List;

@Value
public class MusicPlaylistShelfRendererImpl implements MusicPlaylistShelfRenderer {

    String            playlistId;
    List<ContentImpl> contents;
    Integer           collapsedItemCount;
    String            trackingParams;
    Boolean           contentsMultiSelectable;
    String            targetId;

    @Value
    public static class ContentImpl implements Content {

        MusicResponsiveListItemRendererImpl musicResponsiveListItemRenderer;
    }
}