package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.renderer.MusicQueueRenderer;
import me.knighthat.innertube.response.renderer.SectionListRenderer;

import java.util.List;

public interface Tabs {

    @NotNull
    List<? extends Tab> getTabs();

    interface Tab {

        @NotNull
        Renderer getTabRenderer();

        interface Renderer extends Trackable {

            @Nullable
            Endpoint getEndpoint();

            @Nullable
            String getTitle();

            @Nullable
            Boolean getSelected();

            @NotNull
            Content getContent();

            @Nullable
            Icon getIcon();

            @Nullable
            String getTabIdentifier();

            interface Content {

                @Nullable
                SectionListRenderer getSectionListRenderer();

                @Nullable
                MusicQueueRenderer getMusicQueueRenderer();
            }
        }
    }
}