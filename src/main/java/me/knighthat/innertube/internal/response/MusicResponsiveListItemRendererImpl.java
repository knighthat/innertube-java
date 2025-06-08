package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;

import java.util.List;

@Value
public class MusicResponsiveListItemRendererImpl implements MusicResponsiveListItemRenderer {

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
    public static class ColumnImpl implements Colum {

        RendererImpl musicResponsiveListItemFlexColumnRenderer;
        RendererImpl musicResponsiveListItemFixedColumnRenderer;

        @Value
        public static class RendererImpl implements Renderer {

            RunsImpl text;
            String   displayPriority;
            String   size;
        }
    }

    @Value
    public static class PlaylistItemDataImpl implements PlaylistItemData {

        String playlistSetVideoId;
        String videoId;
    }

    @Value
    public static class MultiSelectCheckboxImpl implements MultiSelectCheckbox {

        RendererImpl checkboxRenderer;

        @Value
        public static class RendererImpl implements Renderer {

            ChangeCommandImpl onSelectionChangeCommand;
            String            checkedState;
            String            trackingParams;

            @Value
            public static class ChangeCommandImpl implements ChangeCommand {

                String            clickTrackingParams;
                UpdateCommandImpl updateMultiSelectStateCommand;

                @Value
                public static class UpdateCommandImpl implements UpdateCommand {

                    String multiSelectParams;
                    String multiSelectItem;
                }
            }
        }
    }
}