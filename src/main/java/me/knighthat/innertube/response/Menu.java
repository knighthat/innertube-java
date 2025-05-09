package me.knighthat.innertube.response;

import java.util.List;

public interface Menu {

    Renderer getMenuRenderer();

    interface Renderer extends Trackable {

        List<? extends Item> getItems();

        List<? extends Button> getTopLevelButtons();

        Accessibility getAccessibility();

        interface Item {

            Navigation getMenuNavigationItemRenderer();

            Service getMenuServiceItemRenderer();

            Toggle getToggleMenuServiceItemRenderer();

            interface Navigation extends Trackable {

                Runs getText();

                Icon getIcon();

                Endpoint getNavigationEndpoint();
            }

            interface Service extends Trackable {

                Runs getText();

                Icon getIcon();

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