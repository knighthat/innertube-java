package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MusicResponsiveListItemRenderer extends Trackable {

    @Nullable
    Thumbnail getThumbnail();

    @Nullable
    Overlay getOverlay();

    @NotNull
    List<? extends Colum> getFlexColumns();

    @NotNull
    List<? extends Colum> getFixedColumns();

    @NotNull
    Menu getMenu();

    @NotNull
    List<? extends Badge> getBadges();

    @Nullable
    PlaylistItemData getPlaylistItemData();

    @Nullable
    String getFlexColumnDisplayStyle();

    @NotNull
    Endpoint getNavigationEndpoint();

    @Nullable
    String getItemHeight();

    @Nullable
    Runs getIndex();

    @Nullable
    MultiSelectCheckbox getMultiSelectCheckbox();

    interface Colum {

        @Nullable
        Renderer getMusicResponsiveListItemFlexColumnRenderer();

        @Nullable
        Renderer getMusicResponsiveListItemFixedColumnRenderer();

        interface Renderer {

            @Nullable
            Runs getText();

            @NotNull
            String getDisplayPriority();

            @Nullable
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