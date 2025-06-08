package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.BrowseResponse;

import java.util.List;

@Value
public class BrowseResponseImpl implements BrowseResponse {

    ResponseContextImpl responseContext;
    ContentsImpl        contents;
    HeaderImpl          header;
    String              trackingParams;
    Integer             maxAgeStoreSeconds;
    MicroformatImpl     microformat;
    ThumbnailImpl       background;

    @Value
    public static class ContentsImpl implements Contents {

        TabsImpl                           singleColumnBrowseResultsRenderer;
        TwoColumnBrowseResultsRendererImpl twoColumnBrowseResultsRenderer;
        SectionListRendererImpl            sectionListRenderer;

        @Value
        public static class TwoColumnBrowseResultsRendererImpl implements TwoColumnBrowseResultsRenderer {

            List<TabsImpl.TabImpl> tabs;
            SecondaryContentsImpl  secondaryContents;

            @Value
            public static class SecondaryContentsImpl implements SecondaryContents {

                SectionListRendererImpl sectionListRenderer;
            }
        }
    }

    @Value
    public static class HeaderImpl implements Header {

        MusicImmersiveHeaderRendererImpl musicImmersiveHeaderRenderer;
        MusicHeaderRendererImpl          musicHeaderRenderer;

        @Value
        public static class MusicImmersiveHeaderRendererImpl implements MusicImmersiveHeaderRenderer {

            RunsImpl      title;
            ButtonImpl    subscriptionButton;
            RunsImpl      description;
            ButtonImpl    moreButton;
            MenuImpl      menu;
            ThumbnailImpl thumbnail;
            String        trackingParams;
            ButtonImpl    playButton;
            ButtonImpl    startRadioButton;
            EndpointImpl  shareEndpoint;
            RunsImpl      monthlyListenerCount;
        }

        @Value
        public static class MusicHeaderRendererImpl implements MusicHeaderRenderer {

            RunsImpl title;
            String   trackingParams;
        }
    }
}