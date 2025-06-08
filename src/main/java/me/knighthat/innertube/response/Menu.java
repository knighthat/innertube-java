package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Menu {

    @NotNull
    Renderer getMenuRenderer();

    interface Renderer extends Trackable {

        @NotNull
        List<? extends Item> getItems();

        @NotNull
        List<? extends Button> getTopLevelButtons();

        @Nullable
        Accessibility getAccessibility();

        interface Item {

            @Nullable
            EndpointItem getMenuNavigationItemRenderer();

            @Nullable
            EndpointItem getMenuServiceItemRenderer();

            @Nullable
            Toggle getToggleMenuServiceItemRenderer();

            interface EndpointItem extends Trackable {

                @NotNull
                Runs getText();

                @NotNull
                Icon getIcon();

                @Nullable
                Endpoint getNavigationEndpoint();

                @Nullable
                Endpoint getServiceEndpoint();
            }

            interface Toggle extends Trackable {

                @NotNull
                Runs getDefaultText();

                @NotNull
                Icon getDefaultIcon();

                @NotNull
                Endpoint getDefaultServiceEndpoint();

                @NotNull
                Runs getToggledText();

                @NotNull
                Icon getToggledIcon();

                @NotNull
                Endpoint getToggledServiceEndpoint();
            }
        }
    }
}