package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Tabs;

import java.util.List;

@Value
class TabsImpl implements Tabs {

    List<TabImpl> tabs;

    @Value
    static class TabImpl implements Tab {

        RendererImpl tabRenderer;

        @Value
        static class RendererImpl implements Renderer {

            EndpointImpl endpoint;
            String       title;
            Boolean      selected;
            ContentImpl  content;
            IconImpl     icon;
            String       tabIdentifier;
            String       trackingParams;

            @Value
            static class ContentImpl implements Content {

                SectionListRendererImpl sectionListRenderer;
                MusicQueueRendererImpl  musicQueueRenderer;
            }
        }
    }
}