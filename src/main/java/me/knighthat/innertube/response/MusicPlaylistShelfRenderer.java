package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MusicPlaylistShelfRenderer extends Trackable {

    @NotNull
    String getPlaylistId();

    @NotNull
    List<? extends Content> getContents();

    @NotNull
    Integer getCollapsedItemCount();

    @NotNull
    Boolean getContentsMultiSelectable();

    @NotNull
    String getTargetId();

    interface Content {

        @Nullable
        MusicResponsiveListItemRenderer getMusicResponsiveListItemRenderer();

        @Nullable
        ContinuationItemRenderer getContinuationItemRenderer();

        interface ContinuationItemRenderer {

            @NotNull
            String getTrigger();

            @NotNull
            Continuation getContinuationEndpoint();

            interface Continuation extends ClickTrackable {

                @NotNull
                Command getContinuationCommand();

                interface Command {

                    @NotNull
                    String getToken();

                    @NotNull
                    String getRequest();
                }
            }
        }
    }
}