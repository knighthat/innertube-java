package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;

import java.util.List;

@Value
class MusicResponsiveListItemRendererImpl implements MusicResponsiveListItemRenderer {

    String                  trackingParams;
    ThumbnailImpl           thumbnail;
    OverlayImpl             overlay;
    List<ColumnImpl>        flexColumns;
    List<ColumnImpl>        fixedColumns;
    MenuImpl                menu;
    List<BadgeImpl>         badges;
    PlaylistItemDataImpl    playlistItemData;
    String                  flexColumnDisplayStyle;
    EndpointImpl            navigationEndpoint;
    String                  itemHeight;
    RunsImpl                index;
    MultiSelectCheckboxImpl multiSelectCheckbox;


    @Value
    static class ColumnImpl implements Colum {

        RendererImpl musicResponsiveListItemFlexColumnRenderer;
        RendererImpl musicResponsiveListItemFixedColumnRenderer;

        @Value
        static class RendererImpl implements Renderer {

            RunsImpl text;
            String   displayPriority;
            String   size;
        }
    }

    @Value
    static class PlaylistItemDataImpl implements PlaylistItemData {

        String playlistSetVideoId;
        String videoId;
    }

    @Value
    static class MultiSelectCheckboxImpl implements MultiSelectCheckbox {

        RendererImpl checkboxRenderer;

        @Value
        static class RendererImpl implements Renderer {

            ChangeCommandImpl onSelectionChangeCommand;
            String            checkedState;
            String            trackingParams;

            @Value
            static class ChangeCommandImpl implements ChangeCommand {

                String            clickTrackingParams;
                UpdateCommandImpl updateMultiSelectStateCommand;

                @Value
                static class UpdateCommandImpl implements UpdateCommand {

                    String multiSelectParams;
                    String multiSelectItem;
                }
            }
        }
    }
}