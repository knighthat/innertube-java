package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Endpoint;

import java.util.List;

@Value
public class EndpointImpl implements Endpoint {

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
    public static class BrowseImpl implements Browse {

        String                                    browseId;
        String                                    params;
        BrowseEndpointContextSupportedConfigsImpl browseEndpointContextSupportedConfigs;

        @Value
        public static class BrowseEndpointContextSupportedConfigsImpl implements BrowseEndpointContextSupportedConfigs {

            BrowseEndpointContextMusicConfigImpl browseEndpointContextMusicConfig;

            @Value
            public static class BrowseEndpointContextMusicConfigImpl implements BrowseEndpointContextMusicConfig {

                String pageType;
            }
        }
    }

    @Value
    public static class FeedbackImpl implements Feedback {

        String feedbackToken;
    }

    @Value
    public static class LikeImpl implements Like {

        String     status;
        TargetImpl target;

        @Value
        public static class TargetImpl implements Target {

            String playlistId;
        }
    }

    @Value
    public static class ModalImpl implements Modal {

        RendererImpl modal;

        @Value
        public static class RendererImpl implements Renderer {

            TitleAndButtonRendererImpl modalWithTitleAndButtonRenderer;

            @Value
            public static class TitleAndButtonRendererImpl implements TitleAndButtonRenderer {

                RunsImpl   title;
                RunsImpl   content;
                ButtonImpl button;
            }
        }
    }

    @Value
    public static class PlaylistEditImpl implements PlaylistEdit {

        String           playlistId;
        List<ActionImpl> actions;

        @Value
        public static class ActionImpl implements Action {

            String setVideoId;
            String action;
            String removedVideoId;
        }
    }

    @Value
    public static class QueueImpl implements Queue {

        @Value
        public static class QueueAddImpl implements QueueAdd {

            QueueTargetImpl   queueTarget;
            String            queueInsertPosition;
            List<CommandImpl> commands;

            @Value
            public static class QueueTargetImpl implements QueueTarget {

                String       videoId;
                String       playlistId;
                EndpointImpl onEmptyQueue;
            }
        }

        @Value
        public static class QueueRemoveImpl implements QueueRemove {

            String            videoId;
            List<CommandImpl> commands;
        }

        @Value
        public static class CommandImpl implements Command {

            String               clickTrackingParams;
            AddToToastActionImpl addToToastAction;

            @Value
            public static class AddToToastActionImpl implements AddToToastAction {

                ItemImpl item;

                @Value
                public static class ItemImpl implements Item {

                    NotificationTextRendererImpl notificationTextRenderer;

                    @Value
                    public static class NotificationTextRendererImpl implements NotificationTextRenderer {

                        RunsImpl successResponseText;
                        String   trackingParams;
                    }
                }
            }
        }
    }

    @Value
    public static class QueueUpdateImpl implements QueueUpdate {

        String       queueUpdateSection;
        EndpointImpl fetchContentsCommand;
        Boolean      dedupeAgainstLocalQueue;
    }

    @Value
    public static class SearchImpl implements Search {

        String query;
        String params;
    }

    @Value
    public static class ShareEntityImpl implements ShareEntity {

        String serializedShareEntity;
        String sharePanelType;
    }

    @Value
    public static class SignInImpl implements SignIn {

        Boolean hack;
    }

    @Value
    public static class WatchImpl implements Watch {

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
        public static class LoggingContextImpl implements LoggingContext {

            VssLoggingContextImpl vssLoggingContext;

            @Value
            public static class VssLoggingContextImpl implements VssLoggingContext {

                String serializedContextData;
            }
        }

        @Value
        public static class WatchEndpointMusicSupportedConfigsImpl implements WatchEndpointMusicSupportedConfigs {

            WatchEndpointMusicConfigImpl watchEndpointMusicConfig;

            @Value
            public static class WatchEndpointMusicConfigImpl implements WatchEndpointMusicConfig {

                Boolean hasPersistentPlaylistPanel;
                String  musicVideoType;
            }
        }
    }

    @Value
    public static class WatchPlaylistImpl implements WatchPlaylist {

        String playlistId;
        String params;
    }

    @Value
    public static class SubscribeImpl implements Subscribe {

        List<String> channelIds;
        String       params;
    }

    @Value
    public static class SignalServiceImpl implements SignalService {

        String           signal;
        List<ActionImpl> actions;

        @Value
        public static class ActionImpl implements Action {

            String        clickTrackingParams;
            OpenPopupImpl openPopupAction;

            @Value
            public static class OpenPopupImpl implements OpenPopup {

                PopupImpl popup;
                String    popupType;

                @Value
                public static class PopupImpl implements Popup {

                    RendererImpl confirmDialogRenderer;

                    @Value
                    public static class RendererImpl implements Renderer {

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