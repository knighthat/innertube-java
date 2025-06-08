package me.knighthat.innertube.response.renderer;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicResponsiveListItemRenderer extends Trackable {

    Thumbnail getThumbnail();

    Overlay getOverlay();

    @NotNull
    List<? extends Colum> getFlexColumns();

    @NotNull
    List<? extends Colum> getFixedColumns();

    Menu getMenu();

    @NotNull
    List<? extends Badge> getBadges();

    PlaylistItemData getPlaylistItemData();

    String getFlexColumnDisplayStyle();

    Endpoint getNavigationEndpoint();

    String getItemHeight();

    Runs getIndex();

    MultiSelectCheckbox getMultiSelectCheckbox();

    interface Colum {

        @Nullable
        Renderer getMusicResponsiveListItemFlexColumnRenderer();

        @Nullable
        Renderer getMusicResponsiveListItemFixedColumnRenderer();

        interface Renderer {

            @NotNull
            Runs getText();

            String getDisplayPriority();

            String getSize();
        }
    }

    interface PlaylistItemData {

        String getPlaylistSetVideoId();

        String getVideoId();
    }

    interface MultiSelectCheckbox {

        Renderer getCheckboxRenderer();

        interface Renderer extends Trackable {

            ChangeCommand getOnSelectionChangeCommand();

            String getCheckedState();

            interface ChangeCommand extends ClickTrackable {

                UpdateCommand getUpdateMultiSelectStateCommand();

                interface UpdateCommand {

                    String getMultiSelectParams();

                    String getMultiSelectItem();
                }
            }
        }
    }
}