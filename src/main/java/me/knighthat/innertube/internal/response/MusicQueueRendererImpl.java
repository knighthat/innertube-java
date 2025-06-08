package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicQueueRenderer;

import java.util.List;

@Value
class MusicQueueRendererImpl implements MusicQueueRenderer {

    ContentImpl            content;
    Boolean                hack;
    HeaderImpl             header;
    SubHeaderChipCloudImpl subHeaderChipCloud;

    @Value
    static class ContentImpl implements Content {

        PlaylistPanelRendererImpl playlistPanelRenderer;
    }

    @Value
    static class HeaderImpl implements Header {

        MusicQueueHeaderRendererImpl musicQueueHeaderRenderer;

        @Value
        static class MusicQueueHeaderRendererImpl implements MusicQueueHeaderRenderer {

            RunsImpl         title;
            RunsImpl         subtitle;
            List<ButtonImpl> buttons;
            String           trackingParams;
        }
    }

    @Value
    static class SubHeaderChipCloudImpl implements SubHeaderChipCloud {

        ChipCloudImpl chipCloudRenderer;
    }
}