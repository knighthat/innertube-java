package me.knighthat.innertube.response;

import java.util.List;

public interface Endpoint {

    String getClickTrackingParams();

    BrowseEndpoint getBrowseEndpoint();

    WatchEndpoint getWatchEndpoint();

    ModalEndpoint getModalEndpoint();

    WatchPlaylistEndpoint getWatchPlaylistEndpoint();

    QueueEndpoint.QueueAdd getQueueAddEndpoint();

    QueueEndpoint.QueueRemove getRemoveFromQueueEndpoint();

    LikeEndpoint getLikeEndpoint();

    ShareEntityEndpoint getShareEntityEndpoint();

    SearchEndpoint getSearchEndpoint();

    SignInEndpoint getSignInEndpoint();

    FeedbackEndpoint getFeedbackEndpoint();

    PlaylistEditEndpoint getPlaylistEditEndpoint();

    QueueUpdateCommand getQueueUpdateCommand();

    interface BrowseEndpoint {

        String getBrowseId();

        String getParams();

        BrowseEndpointContextSupportedConfigs getBrowseEndpointContextSupportedConfigs();

        interface BrowseEndpointContextSupportedConfigs {

            BrowseEndpointContextMusicConfig getBrowseEndpointContextMusicConfig();

            interface BrowseEndpointContextMusicConfig {

                String getPageType();
            }
        }
    }

    interface FeedbackEndpoint {

        String getFeedbackToken();
    }

    interface LikeEndpoint {

        String getStatus();

        Target getTarget();

        interface Target {

            String getPlaylistId();
        }
    }

    interface ModalEndpoint {

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

    interface PlaylistEditEndpoint {

        String getPlaylistId();

        List<PlaylistEditEndpoint.Action> getActions();

        interface Action {

            String getSetVideoId();

            String getAction();

            String getRemovedVideoId();
        }
    }

    interface QueueEndpoint {

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

                    Item.NotificationTextRenderer getNotificationTextRenderer();

                    interface NotificationTextRenderer {

                        Runs getSuccessResponseText();

                        String getTrackingParams();
                    }
                }
            }
        }
    }

    interface QueueUpdateCommand {

        String getQueueUpdateSection();

        FetchContentsCommand getFetchContentsCommand();

        Boolean getDedupeAgainstLocalQueue();

        interface FetchContentsCommand {

            String getClickTrackingParams();

            WatchEndpoint getWatchEndpoint();
        }
    }

    interface SearchEndpoint {

        String getQuery();

        String getParams();
    }

    interface ShareEntityEndpoint {

        String getSerializedShareEntity();

        String getSharePanelType();
    }

    interface SignInEndpoint {

        Boolean getHack();
    }

    interface WatchEndpoint {

        String getVideoId();

        String getPlaylistId();

        Integer getIndex();

        String getPlayerParams();

        String getUstreamerConfig();

        String getParams();

        String getPlaylistSetVideoId();

        LoggingContext getLoggingContext();

        WatchEndpointMusicSupportedConfigs getWatchEndpointMusicSupportedConfigs();

        interface LoggingContext {

            LoggingContext.VssLoggingContext getVssLoggingContext();

            interface VssLoggingContext {

                String getSerializedContextData();
            }
        }

        interface WatchEndpointMusicSupportedConfigs {

            WatchEndpointMusicConfig getWatchEndpointMusicConfig();

            interface WatchEndpointMusicConfig {

                Boolean getHasPersistentPlaylistPanel();

                String getMusicVideoType();
            }
        }
    }

    interface WatchPlaylistEndpoint {

        String getPlaylistId();

        String getParams();
    }
}