package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.BrowseResponse;

import java.util.List;

@Value
class BrowseResponseImpl implements BrowseResponse {

    ResponseContextImpl              responseContext;
    ContentsImpl                     contents;
    HeaderImpl                       header;
    String                           trackingParams;
    Integer                          maxAgeStoreSeconds;
    MicroformatImpl                  microformat;
    ThumbnailImpl                    background;
    List<ResponseReceivedActionImpl> onResponseReceivedActions;

    @Value
    static class ContentsImpl implements Contents {

        TabsImpl                           singleColumnBrowseResultsRenderer;
        TwoColumnBrowseResultsRendererImpl twoColumnBrowseResultsRenderer;
        SectionListRendererImpl            sectionListRenderer;

        @Value
        static class TwoColumnBrowseResultsRendererImpl implements TwoColumnBrowseResultsRenderer {

            List<TabsImpl.TabImpl> tabs;
            SecondaryContentsImpl  secondaryContents;

            @Value
            static class SecondaryContentsImpl implements SecondaryContents {

                SectionListRendererImpl sectionListRenderer;
            }
        }
    }

    @Value
    static class HeaderImpl implements Header {

        MusicImmersiveHeaderRendererImpl musicImmersiveHeaderRenderer;
        MusicHeaderRendererImpl          musicHeaderRenderer;

        @Value
        static class MusicImmersiveHeaderRendererImpl implements MusicImmersiveHeaderRenderer {

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
        static class MusicHeaderRendererImpl implements MusicHeaderRenderer {

            RunsImpl title;
            String   trackingParams;
        }
    }

    @Value
    static class ResponseReceivedActionImpl implements ResponseReceivedAction {

        AppendContinuationItemsActionImpl appendContinuationItemsAction;
        String                            clickTrackingParams;

        @Value
        static class AppendContinuationItemsActionImpl implements AppendContinuationItemsAction {

            List<MusicPlaylistShelfRendererImpl.ContentImpl> continuationItems;
        }
    }
}