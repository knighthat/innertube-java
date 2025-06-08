package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Menu {

    Renderer getMenuRenderer();

    interface Renderer extends Trackable {

        @NotNull
        List<? extends Item> getItems();

        @NotNull
        List<? extends Button> getTopLevelButtons();

        Accessibility getAccessibility();

        interface Item {

            @Nullable
            EndpointItem getMenuNavigationItemRenderer();

            @Nullable
            EndpointItem getMenuServiceItemRenderer();

            Toggle getToggleMenuServiceItemRenderer();

            interface EndpointItem extends Trackable {

                @NotNull
                Runs getText();

                @NotNull
                Icon getIcon();

                @Nullable
                Endpoint getNavigationEndpoint();
            }

            interface Service extends Trackable {

                @Nullable
                Endpoint getServiceEndpoint();
            }

            interface Toggle extends Trackable {

                Runs getDefaultText();

                Icon getDefaultIcon();

                Endpoint getDefaultServiceEndpoint();

                Runs getToggledText();

                Icon getToggledIcon();

                Endpoint getToggledServiceEndpoint();
            }
        }
    }
}