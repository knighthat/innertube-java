package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Menu;

import java.util.List;

@Value
class MenuImpl implements Menu {

    RendererImpl menuRenderer;

    @Value
    static class RendererImpl implements Renderer {

        List<ItemImpl>    items;
        String            trackingParams;
        List<ButtonImpl>  topLevelButtons;
        AccessibilityImpl accessibility;

        @Value
        static class ItemImpl implements Item {

            EndpointItemImpl menuNavigationItemRenderer;
            EndpointItemImpl menuServiceItemRenderer;
            ToggleImpl       toggleMenuServiceItemRenderer;

            @Value
            static class EndpointItemImpl implements EndpointItem {

                RunsImpl     text;
                IconImpl     icon;
                EndpointImpl navigationEndpoint;
                EndpointImpl serviceEndpoint;
                String       trackingParams;
            }

            @Value
            static class ToggleImpl implements Toggle {

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