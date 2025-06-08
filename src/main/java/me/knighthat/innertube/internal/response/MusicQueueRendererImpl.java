package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicQueueRenderer;

import java.util.List;

@Value
public class MusicQueueRendererImpl implements MusicQueueRenderer {

    ContentImpl            content;
    Boolean                hack;
    HeaderImpl             header;
    SubHeaderChipCloudImpl subHeaderChipCloud;

    @Value
    public static class ContentImpl implements Content {

        PlaylistPanelRendererImpl playlistPanelRenderer;
    }

    @Value
    public static class HeaderImpl implements Header {

        MusicQueueHeaderRendererImpl musicQueueHeaderRenderer;

        @Value
        public static class MusicQueueHeaderRendererImpl implements MusicQueueHeaderRenderer {

            RunsImpl         title;
            RunsImpl         subtitle;
            List<ButtonImpl> buttons;
            String           trackingParams;
        }
    }

    @Value
    public static class SubHeaderChipCloudImpl implements SubHeaderChipCloud {

        ChipCloudImpl chipCloudRenderer;
    }
}