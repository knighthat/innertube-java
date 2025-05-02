package me.knighthat.innertube.response;

import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.renderer.MusicQueueRenderer;
import me.knighthat.innertube.response.renderer.SectionListRenderer;

import java.util.List;

public interface Tabs {

    List<Tab> getTabs();

    interface Tab {

        TabRenderer getTabRenderer();

        interface TabRenderer {

            Endpoint getEndpoint();

            String getTitle();

            Boolean getSelected();

            Content getContent();

            Icon getIcon();

            String getTabIdentifier();

            String getTrackingParams();

            interface Content {

                SectionListRenderer getSectionListRenderer();

                MusicQueueRenderer getMusicQueueRenderer();
            }
        }
    }
}