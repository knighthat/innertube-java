package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.PrimaryResults;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Value
class PrimaryResultsImpl implements PrimaryResults {

    ResultsImpl results;

    @Value
    static class ResultsImpl implements Results {

        ContentsImpl contents;

        @Value
        static class ContentsImpl implements Contents {

            VideoPrimaryInfoRendererImpl   videoPrimaryInfoRenderer;
            VideoSecondaryInfoRendererImpl videoSecondaryInfoRenderer;

            @Value
            static class VideoPrimaryInfoRendererImpl implements VideoPrimaryInfoRenderer {

                @NotNull String trackingParams;
                RunsImpl       title;
                ViewCountImpl  viewCount;
                MenuImpl       videoActions;
                SimpleTextImpl dateText;
                SimpleTextImpl relativeDateText;

                @Value
                static class ViewCountImpl implements ViewCount {

                    VideoViewCountRendererImpl videoViewCountRenderer;

                    @Value
                    static class VideoViewCountRendererImpl implements VideoViewCountRenderer {

                        SimpleTextImpl viewCount;
                        SimpleTextImpl shortViewCount;
                        String         originalViewCount;
                    }
                }
            }

            @Value
            static class VideoSecondaryInfoRendererImpl implements VideoSecondaryInfoRenderer {

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
                static class OwnerImpl implements Owner {

                    ThumbnailImpl.RendererImpl videoOwnerRenderer;
                    ButtonImpl.SubscribeImpl   subscriptionButton;
                    EndpointImpl               navigationEndpoint;
                    SimpleTextImpl             subscriberCountText;
                    @NotNull List<? extends Badge> badges;
                }

                @Value
                static class MetadataRowContainerImpl implements MetadataRowContainer {

                    Renderer metadataRowContainerRenderer;

                    @Value
                    static class RendererImpl implements Renderer {

                        @NotNull String trackingParams;
                        Integer collapsedItemCount;
                    }
                }

                @Value
                static class ClickableCommandImpl implements ClickableCommand {

                    @NotNull String clickTrackingParams;
                    ExecutorImpl commandExecutorCommand;

                    @Value
                    static class ExecutorImpl implements Executor {

                        @NotNull List<CommandImpl> commands;

                        @Value
                        static class CommandImpl implements Command {

                            @NotNull String clickTrackingParams;
                            ChangeEngagementPanelVisibilityActionImpl changeEngagementPanelVisibilityAction;

                            @Value
                            static class ChangeEngagementPanelVisibilityActionImpl implements ChangeEngagementPanelVisibilityAction {

                                String targetId;
                                String visibility;
                            }
                        }
                    }
                }

                @Value
                static class AttributedDescriptionImpl implements AttributedDescription {

                    String content;
                    @NotNull List<StyleImpl> styleRuns;
                }
            }
        }
    }
}
