package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Endpoint extends ClickTrackable{

    @Nullable
    Browse getBrowseEndpoint();

    @Nullable
    Watch getWatchEndpoint();

    @Nullable
    Modal getModalEndpoint();

    @Nullable
    WatchPlaylist getWatchPlaylistEndpoint();

    @Nullable
    Queue.QueueAdd getQueueAddEndpoint();

    @Nullable
    Queue.QueueRemove getRemoveFromQueueEndpoint();

    @Nullable
    Like getLikeEndpoint();

    @Nullable
    ShareEntity getShareEntityEndpoint();

    @Nullable
    Search getSearchEndpoint();

    @Nullable
    SignIn getSignInEndpoint();

    @Nullable
    Feedback getFeedbackEndpoint();

    @Nullable
    PlaylistEdit getPlaylistEditEndpoint();

    @Nullable
    QueueUpdate getQueueUpdateCommand();

    @Nullable
    Subscribe getSubscribeEndpoint();

    @Nullable
    Subscribe getUnsubscribeEndpoint();

    @Nullable
    SignalService getSignalServiceEndpoint();

    interface Browse {

        @NotNull
        String getBrowseId();

        @Nullable
        String getParams();

        @Nullable
        Context getBrowseEndpointContextSupportedConfigs();

        interface Context {

            @NotNull
            MusicConfig getBrowseEndpointContextMusicConfig();

            interface MusicConfig {

                @NotNull
                String getPageType();
            }
        }
    }

    interface Feedback {

        @NotNull
        String getFeedbackToken();
    }

    interface Like {

        @NotNull
        String getStatus();

        @NotNull
        Target getTarget();

        interface Target {

            @NotNull
            String getPlaylistId();
        }
    }

    interface Modal {

        @NotNull
        Renderer getModal();

        interface Renderer {

            @NotNull
            TitleAndButtonRenderer getModalWithTitleAndButtonRenderer();

            interface TitleAndButtonRenderer {

                @NotNull
                Runs getTitle();

                @NotNull
                Runs getContent();

                @NotNull
                Button getButton();
            }
        }
    }

    interface PlaylistEdit {

        @NotNull
        String getPlaylistId();

        @NotNull
        List<? extends PlaylistEdit.Action> getActions();

        interface Action {

            @NotNull
            String getSetVideoId();

            @NotNull
            String getAction();

            @NotNull
            String getRemovedVideoId();
        }
    }

    interface Queue {

        interface QueueAdd {

            @NotNull
            QueueTarget getQueueTarget();

            @NotNull
            String getQueueInsertPosition();

            @NotNull
            List<? extends Command> getCommands();

            interface QueueTarget {

                @Nullable
                String getVideoId();

                @NotNull
                String getPlaylistId();

                @NotNull
                Endpoint getOnEmptyQueue();
            }
        }

        interface QueueRemove {

            @NotNull
            String getVideoId();

            @NotNull
            List<? extends Command> getCommands();
        }

        interface Command extends ClickTrackable {

            @NotNull
            AddToToastAction getAddToToastAction();

            interface AddToToastAction {

                @NotNull
                Item getItem();

                interface Item {

                    @NotNull
                    Item.NotificationTextRenderer getNotificationTextRenderer();

                    interface NotificationTextRenderer extends Trackable{

                        @NotNull
                        Runs getSuccessResponseText();
                    }
                }
            }
        }
    }

    interface QueueUpdate {

        @NotNull
        String getQueueUpdateSection();

        @NotNull
        Endpoint getFetchContentsCommand();

        @NotNull
        Boolean getDedupeAgainstLocalQueue();
    }

    interface Search {

        @NotNull
        String getQuery();

        @Nullable
        String getParams();
    }

    interface ShareEntity {

        @NotNull
        String getSerializedShareEntity();

        @NotNull
        String getSharePanelType();
    }

    interface SignIn {

        @NotNull
        Boolean getHack();
    }

    interface Watch {

        @NotNull
        String getVideoId();

        @Nullable
        String getPlaylistId();

        @Nullable
        Integer getIndex();

        @Nullable
        String getParams();

        @Nullable
        String getPlayerParams();

        @Nullable
        String getUstreamerConfig();

        @Nullable
        String getPlaylistSetVideoId();

        @Nullable
        LoggingContext getLoggingContext();

        @Nullable
        WatchEndpointMusicSupportedConfigs getWatchEndpointMusicSupportedConfigs();

        interface LoggingContext {

            @NotNull
            LoggingContext.VssLoggingContext getVssLoggingContext();

            interface VssLoggingContext {

                @NotNull
                String getSerializedContextData();
            }
        }

        interface WatchEndpointMusicSupportedConfigs {

            @NotNull
            WatchEndpointMusicConfig getWatchEndpointMusicConfig();

            interface WatchEndpointMusicConfig {

                @Nullable
                Boolean getHasPersistentPlaylistPanel();

                @NotNull
                String getMusicVideoType();
            }
        }
    }

    interface WatchPlaylist {

        @Nullable
        String getPlaylistId();

        @Nullable
        String getParams();
    }

    interface Subscribe {

        @NotNull
        List<String> getChannelIds();

        @Nullable
        String getParams();
    }

    interface SignalService {

        @NotNull
        String getSignal();

        @NotNull
        List<? extends Action> getActions();

        interface Action extends ClickTrackable {

            @NotNull
            OpenPopup getOpenPopupAction();

            interface OpenPopup {

                @NotNull
                Popup getPopup();

                @NotNull
                String getPopupType();

                interface Popup {

                    @NotNull
                    Renderer getConfirmDialogRenderer();

                    interface Renderer extends Trackable {

                        @NotNull
                        List<? extends Runs> getDialogMessages();

                        @Nullable
                        Button getConfirmButton();

                        @Nullable
                        Button getCancelButton();
                    }
                }
            }
        }
    }
}