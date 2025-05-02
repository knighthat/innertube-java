package me.knighthat.innertube.response.endpoint;


import me.knighthat.innertube.response.Runs;

import java.util.List;

public interface QueueEndpoint {

    interface QueueAdd {

        QueueTarget getQueueTarget();

        String getQueueInsertPosition();

        List<Command> getCommands();

        interface QueueTarget {

            String getVideoId();

            String getPlaylistId();

            Endpoint getOnEmptyQueue();
        }
    }

    interface QueueRemove {

        String getVideoId();

        List<Command> getCommands();
    }

    interface Command {

        String getClickTrackingParams();

        AddToToastAction getAddToToastAction();

        interface AddToToastAction {

            Item getItem();

            interface Item {

                NotificationTextRenderer getNotificationTextRenderer();

                interface NotificationTextRenderer {

                    Runs getSuccessResponseText();

                    String getTrackingParams();
                }
            }
        }
    }
}