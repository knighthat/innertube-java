package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Endpoint;

import java.util.List;

@Value
class EndpointImpl implements Endpoint {

    String                    clickTrackingParams;
    BrowseImpl                browseEndpoint;
    WatchImpl                 watchEndpoint;
    ModalImpl                 modalEndpoint;
    WatchPlaylistImpl         watchPlaylistEndpoint;
    QueueImpl.QueueAddImpl    queueAddEndpoint;
    QueueImpl.QueueRemoveImpl removeFromQueueEndpoint;
    LikeImpl                  likeEndpoint;
    ShareEntityImpl           shareEntityEndpoint;
    SearchImpl                searchEndpoint;
    SignInImpl                signInEndpoint;
    FeedbackImpl              feedbackEndpoint;
    PlaylistEditImpl          playlistEditEndpoint;
    QueueUpdateImpl           queueUpdateCommand;
    SubscribeImpl             subscribeEndpoint;
    SubscribeImpl             unsubscribeEndpoint;
    SignalServiceImpl         signalServiceEndpoint;

    @Value
    static class BrowseImpl implements Browse {

        String      browseId;
        String      params;
        ContextImpl browseEndpointContextSupportedConfigs;

        @Value
        static class ContextImpl implements Context {

            MusicConfigImpl browseEndpointContextMusicConfig;

            @Value
            static class MusicConfigImpl implements MusicConfig {

                String pageType;
            }
        }
    }

    @Value
    static class FeedbackImpl implements Feedback {

        String feedbackToken;
    }

    @Value
    static class LikeImpl implements Like {

        String     status;
        TargetImpl target;

        @Value
        static class TargetImpl implements Target {

            String playlistId;
        }
    }

    @Value
    static class ModalImpl implements Modal {

        RendererImpl modal;

        @Value
        static class RendererImpl implements Renderer {

            TitleAndButtonRendererImpl modalWithTitleAndButtonRenderer;

            @Value
            static class TitleAndButtonRendererImpl implements TitleAndButtonRenderer {

                RunsImpl   title;
                RunsImpl   content;
                ButtonImpl button;
            }
        }
    }

    @Value
    static class PlaylistEditImpl implements PlaylistEdit {

        String           playlistId;
        List<ActionImpl> actions;

        @Value
        static class ActionImpl implements Action {

            String setVideoId;
            String action;
            String removedVideoId;
        }
    }

    @Value
    static class QueueImpl implements Queue {

        @Value
        static class QueueAddImpl implements QueueAdd {

            QueueTargetImpl   queueTarget;
            String            queueInsertPosition;
            List<CommandImpl> commands;

            @Value
            static class QueueTargetImpl implements QueueTarget {

                String       videoId;
                String       playlistId;
                EndpointImpl onEmptyQueue;
            }
        }

        @Value
        static class QueueRemoveImpl implements QueueRemove {

            String            videoId;
            List<CommandImpl> commands;
        }

        @Value
        static class CommandImpl implements Command {

            String               clickTrackingParams;
            AddToToastActionImpl addToToastAction;

            @Value
            static class AddToToastActionImpl implements AddToToastAction {

                ItemImpl item;

                @Value
                static class ItemImpl implements Item {

                    NotificationTextRendererImpl notificationTextRenderer;

                    @Value
                    static class NotificationTextRendererImpl implements NotificationTextRenderer {

                        RunsImpl successResponseText;
                        String   trackingParams;
                    }
                }
            }
        }
    }

    @Value
    static class QueueUpdateImpl implements QueueUpdate {

        String       queueUpdateSection;
        EndpointImpl fetchContentsCommand;
        Boolean      dedupeAgainstLocalQueue;
    }

    @Value
    static class SearchImpl implements Search {

        String query;
        String params;
    }

    @Value
    static class ShareEntityImpl implements ShareEntity {

        String serializedShareEntity;
        String sharePanelType;
    }

    @Value
    static class SignInImpl implements SignIn {

        Boolean hack;
    }

    @Value
    static class WatchImpl implements Watch {

        String                                 videoId;
        String                                 playlistId;
        Integer                                index;
        String                                 params;
        String                                 playerParams;
        String                                 ustreamerConfig;
        String                                 playlistSetVideoId;
        LoggingContextImpl                     loggingContext;
        WatchEndpointMusicSupportedConfigsImpl watchEndpointMusicSupportedConfigs;

        @Value
        static class LoggingContextImpl implements LoggingContext {

            VssLoggingContextImpl vssLoggingContext;

            @Value
            static class VssLoggingContextImpl implements VssLoggingContext {

                String serializedContextData;
            }
        }

        @Value
        static class WatchEndpointMusicSupportedConfigsImpl implements WatchEndpointMusicSupportedConfigs {

            WatchEndpointMusicConfigImpl watchEndpointMusicConfig;

            @Value
            static class WatchEndpointMusicConfigImpl implements WatchEndpointMusicConfig {

                Boolean hasPersistentPlaylistPanel;
                String  musicVideoType;
            }
        }
    }

    @Value
    static class WatchPlaylistImpl implements WatchPlaylist {

        String playlistId;
        String params;
    }

    @Value
    static class SubscribeImpl implements Subscribe {

        List<String> channelIds;
        String       params;
    }

    @Value
    static class SignalServiceImpl implements SignalService {

        String           signal;
        List<ActionImpl> actions;

        @Value
        static class ActionImpl implements Action {

            String        clickTrackingParams;
            OpenPopupImpl openPopupAction;

            @Value
            static class OpenPopupImpl implements OpenPopup {

                PopupImpl popup;
                String    popupType;

                @Value
                static class PopupImpl implements Popup {

                    RendererImpl confirmDialogRenderer;

                    @Value
                    static class RendererImpl implements Renderer {

                        String         trackingParams;
                        List<RunsImpl> dialogMessages;
                        ButtonImpl     confirmButton;
                        ButtonImpl     cancelButton;
                    }
                }
            }
        }
    }
}