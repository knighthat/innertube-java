package me.knighthat.innertube.response;

import java.util.List;

public interface Menu {

    MenuRenderer getMenuRenderer();

    interface MenuRenderer {

        List<Item> getItems();

        String getTrackingParams();

        List<Button> getTopLevelButtons();

        Accessibility getAccessibility();

        interface Item {

            MenuNavigationItemRenderer getMenuNavigationItemRenderer();

            MenuServiceItemRenderer getMenuServiceItemRenderer();

            ToggleMenuServiceItemRenderer getToggleMenuServiceItemRenderer();

            interface MenuNavigationItemRenderer {

                Runs getText();

                Icon getIcon();

                Endpoint getNavigationEndpoint();

                String getTrackingParams();
            }

            interface MenuServiceItemRenderer {

                Runs getText();

                Icon getIcon();

                Endpoint getServiceEndpoint();

                String getTrackingParams();
            }

            interface ToggleMenuServiceItemRenderer {

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