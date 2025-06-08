package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.PrimaryResults;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Value
public class PrimaryResultsImpl implements PrimaryResults {

    ResultsImpl results;

    @Value
    public static class ResultsImpl implements Results {

        ContentsImpl contents;

        @Value
        public static class ContentsImpl implements Contents {

            VideoPrimaryInfoRendererImpl   videoPrimaryInfoRenderer;
            VideoSecondaryInfoRendererImpl videoSecondaryInfoRenderer;

            @Value
            public static class VideoPrimaryInfoRendererImpl implements VideoPrimaryInfoRenderer {

                @NotNull String trackingParams;
                RunsImpl       title;
                ViewCountImpl  viewCount;
                MenuImpl       videoActions;
                SimpleTextImpl dateText;
                SimpleTextImpl relativeDateText;

                @Value
                public static class ViewCountImpl implements ViewCount {

                    VideoViewCountRendererImpl videoViewCountRenderer;

                    @Value
                    public static class VideoViewCountRendererImpl implements VideoViewCountRenderer {

                        SimpleTextImpl viewCount;
                        SimpleTextImpl shortViewCount;
                        String         originalViewCount;
                    }
                }
            }

            @Value
            public static class VideoSecondaryInfoRendererImpl implements VideoSecondaryInfoRenderer {

                @NotNull String trackingParams;
                OwnerImpl                                     owner;
                ButtonImpl                                    subscribeButton;
                MetadataRowContainerImpl                      metadataRowContainer;
                SimpleTextImpl                                showMoreText;
                SimpleTextImpl                                showLessText;
                Boolean                                       defaultExpanded;
                Integer                                       descriptionCollapsedLines;
                ClickableCommandImpl                          showMoreCommand;
                ClickableCommandImpl.ExecutorImpl.CommandImpl showLessCommand;
                AttributedDescriptionImpl                     attributedDescription;
                @NotNull List<StyleImpl> headerRuns;

                @Value
                public static class OwnerImpl implements Owner {

                    ThumbnailImpl.RendererImpl videoOwnerRenderer;
                    ButtonImpl.SubscribeImpl   subscriptionButton;
                    EndpointImpl               navigationEndpoint;
                    SimpleTextImpl             subscriberCountText;
                    @NotNull List<? extends Badge> badges;
                }

                @Value
                public static class MetadataRowContainerImpl implements MetadataRowContainer {

                    Renderer metadataRowContainerRenderer;

                    @Value
                    public static class RendererImpl implements Renderer {

                        @NotNull String trackingParams;
                        Integer collapsedItemCount;
                    }
                }

                @Value
                public static class ClickableCommandImpl implements ClickableCommand {

                    @NotNull String clickTrackingParams;
                    ExecutorImpl commandExecutorCommand;

                    @Value
                    public static class ExecutorImpl implements Executor {

                        @NotNull List<CommandImpl> commands;

                        @Value
                        public static class CommandImpl implements Command {

                            @NotNull String clickTrackingParams;
                            ChangeEngagementPanelVisibilityActionImpl changeEngagementPanelVisibilityAction;

                            @Value
                            public static class ChangeEngagementPanelVisibilityActionImpl implements ChangeEngagementPanelVisibilityAction {

                                String targetId;
                                String visibility;
                            }
                        }
                    }
                }

                @Value
                public static class AttributedDescriptionImpl implements AttributedDescription {

                    String content;
                    @NotNull List<StyleImpl> styleRuns;
                }
            }
        }
    }
}
