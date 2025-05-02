package me.knighthat.innertube.response.endpoint;

import me.knighthat.innertube.response.Runs;
import me.knighthat.innertube.response.button.Button;

public interface ModalEndpoint {

    Modal getModal();

    interface Modal {

        ModalWithTitleAndButtonRenderer getModalWithTitleAndButtonRenderer();

        interface ModalWithTitleAndButtonRenderer {

            Runs getTitle();

            Runs getContent();

            Button getButton();
        }
    }
}