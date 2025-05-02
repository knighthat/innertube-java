package me.knighthat.innertube.response.menu;

import me.knighthat.innertube.response.Accessibility;
import me.knighthat.innertube.response.Icon;
import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;
import me.knighthat.innertube.response.endpoint.Endpoint;

import java.util.List;

public interface MenuRenderer {

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