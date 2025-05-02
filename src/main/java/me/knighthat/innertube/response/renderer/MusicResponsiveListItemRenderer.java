package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.*;
import me.knighthat.innertube.response.thumbnail.Thumbnail;

import java.util.List;

public interface MusicResponsiveListItemRenderer {

    String getTrackingParams();

    Thumbnail getThumbnail();

    Overlay getOverlay();

    List<FlexColumn> getFlexColumns();

    List<FixedColumn> getFixedColumns();

    Menu getMenu();

    PlaylistItemData getPlaylistItemData();

    List<Badge> getBadges();

    String getFlexColumnDisplayStyle();

    Endpoint getNavigationEndpoint();

    String getItemHeight();

    Runs getIndex();

    MultiSelectCheckbox getMultiSelectCheckbox();


    interface FlexColumn {

        Renderer getMusicResponsiveListItemFlexColumnRenderer();

        interface Renderer {

            Runs getText();

            String getDisplayPriority();
        }
    }

    interface FixedColumn {

        Renderer getMusicResponsiveListItemFixedColumnRenderer();

        interface Renderer {

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

        interface Renderer {

            ChangeCommand getOnSelectionChangeCommand();

            String getCheckedState();

            String getTrackingParams();

            interface ChangeCommand {

                String getClickTrackingParams();

                UpdateCommand getUpdateMultiSelectStateCommand();

                interface UpdateCommand {

                    String getMultiSelectParams();

                    String getMultiSelectItem();
                }
            }
        }
    }
}