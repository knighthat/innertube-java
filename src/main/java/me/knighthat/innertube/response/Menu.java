package me.knighthat.innertube.response;

import java.util.List;

public interface Menu {

    Renderer getMenuRenderer();

    interface Renderer {

        List<? extends Item> getItems();

        String getTrackingParams();

        List<? extends Button> getTopLevelButtons();

        Accessibility getAccessibility();

        interface Item {

            Navigation getMenuNavigationItemRenderer();

            Service getMenuServiceItemRenderer();

            Toggle getToggleMenuServiceItemRenderer();

            interface Navigation {

                Runs getText();

                Icon getIcon();

                Endpoint getNavigationEndpoint();

                String getTrackingParams();
            }

            interface Service {

                Runs getText();

                Icon getIcon();

                Endpoint getServiceEndpoint();

                String getTrackingParams();
            }

            interface Toggle {

                Runs getDefaultText();

                Icon getDefaultIcon();

                Endpoint getDefaultServiceEndpoint();

                Runs getToggledText();

                Icon getToggledIcon();

                Endpoint getToggledServiceEndpoint();

                String getTrackingParams();
            }
        }
    }
}