package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Menu;

import java.util.List;

@Value
public class MenuImpl implements Menu {

    RendererImpl menuRenderer;

    @Value
    public static class RendererImpl implements Renderer {

        List<ItemImpl>    items;
        String            trackingParams;
        List<ButtonImpl>  topLevelButtons;
        AccessibilityImpl accessibility;

        @Value
        public static class ItemImpl implements Item {

            EndpointItemImpl menuNavigationItemRenderer;
            EndpointItemImpl menuServiceItemRenderer;
            ToggleImpl       toggleMenuServiceItemRenderer;

            @Value
            public static class EndpointItemImpl implements EndpointItem {

                RunsImpl     text;
                IconImpl     icon;
                EndpointImpl navigationEndpoint;
                EndpointImpl serviceEndpoint;
                String       trackingParams;
            }

            @Value
            public static class ToggleImpl implements Toggle {

                RunsImpl     defaultText;
                IconImpl     defaultIcon;
                EndpointImpl defaultServiceEndpoint;
                RunsImpl     toggledText;
                IconImpl     toggledIcon;
                EndpointImpl toggledServiceEndpoint;
                String       trackingParams;
            }
        }
    }
}