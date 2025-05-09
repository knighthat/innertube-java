package me.knighthat.innertube.response;

import me.knighthat.innertube.response.renderer.MusicQueueRenderer;
import me.knighthat.innertube.response.renderer.SectionListRenderer;

import java.util.List;

public interface Tabs {

    List<? extends Tab> getTabs();

    interface Tab {

        Renderer getTabRenderer();

        interface Renderer extends Trackable {

            Endpoint getEndpoint();

            String getTitle();

            Boolean getSelected();

            Content getContent();

            Icon getIcon();

            String getTabIdentifier();

            interface Content {

                SectionListRenderer getSectionListRenderer();

                MusicQueueRenderer getMusicQueueRenderer();
            }
        }
    }
}