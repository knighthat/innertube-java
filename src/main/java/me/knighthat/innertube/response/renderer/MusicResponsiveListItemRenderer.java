package me.knighthat.innertube.response.renderer;

import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.Overlay;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.endpoint.Endpoint;
import me.knighthat.innertube.response.menu.Menu;
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

        MusicResponsiveListItemFlexColumnRenderer getMusicResponsiveListItemFlexColumnRenderer();
    }

    interface FixedColumn {

        MusicResponsiveListItemFixedColumnRenderer getMusicResponsiveListItemFixedColumnRenderer();
    }

    interface PlaylistItemData {

        String getPlaylistSetVideoId();

        String getVideoId();
    }

    interface MultiSelectCheckbox {

        CheckboxRenderer getCheckboxRenderer();

        interface CheckboxRenderer {

            OnSelectionChangeCommand getOnSelectionChangeCommand();

            String getCheckedState();

            String getTrackingParams();

            interface OnSelectionChangeCommand {

                String getClickTrackingParams();

                UpdateMultiSelectStateCommand getUpdateMultiSelectStateCommand();

                interface UpdateMultiSelectStateCommand {

                    String getMultiSelectParams();

                    String getMultiSelectItem();
                }
            }
        }
    }
}