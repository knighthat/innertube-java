package me.knighthat.impl.response;

import lombok.Data;
import me.knighthat.impl.response.thumbnail.ThumbnailImpl;
import me.knighthat.innertube.response.Badge;
import me.knighthat.innertube.response.PrimaryResults;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class PrimaryResultsImpl implements PrimaryResults {

    private final ResultsImpl results;

    @Data
    public static class ResultsImpl implements Results {

        private final ContentsImpl contents;

        @Data
        public static class ContentsImpl implements Contents {

            private final VideoPrimaryInfoRendererImpl   videoPrimaryInfoRenderer;
            private final VideoSecondaryInfoRendererImpl videoSecondaryInfoRenderer;

            @Data
            public static class VideoPrimaryInfoRendererImpl implements VideoPrimaryInfoRenderer {

                private final @NotNull String         trackingParams;
                private final          RunsImpl       title;
                private final          ViewCountImpl  viewCount;
                private final          MenuImpl       videoActions;
                private final          SimpleTextImpl dateText;
                private final          SimpleTextImpl relativeDateText;

                @Data
                public static class ViewCountImpl implements ViewCount {

                    private final VideoViewCountRendererImpl videoViewCountRenderer;

                    @Data
                    public static class VideoViewCountRendererImpl implements VideoViewCountRenderer {

                        private final SimpleTextImpl viewCount;
                        private final SimpleTextImpl shortViewCount;
                        private final String         originalViewCount;
                    }
                }
            }

            @Data
            public static class VideoSecondaryInfoRendererImpl implements VideoSecondaryInfoRenderer {

                private final @NotNull String                                        trackingParams;
                private final          OwnerImpl                                     owner;
                private final          ButtonImpl                                    subscribeButton;
                private final          MetadataRowContainerImpl                      metadataRowContainer;
                private final          SimpleTextImpl                                showMoreText;
                private final          SimpleTextImpl                                showLessText;
                private final          Boolean                                       defaultExpanded;
                private final          Integer                                       descriptionCollapsedLines;
                private final          ClickableCommandImpl                          showMoreCommand;
                private final          ClickableCommandImpl.ExecutorImpl.CommandImpl showLessCommand;
                private final          AttributedDescriptionImpl                     attributedDescription;
                private final @NotNull List<StyleImpl>                               headerRuns;

                @Data
                public static class OwnerImpl implements Owner {

                    private final          ThumbnailImpl.RendererImpl videoOwnerRenderer;
                    private final          ButtonImpl.SubscribeImpl   subscriptionButton;
                    private final          EndpointImpl               navigationEndpoint;
                    private final          SimpleTextImpl             subscriberCountText;
                    private final @NotNull List<? extends Badge>      badges;
                }

                @Data
                public static class MetadataRowContainerImpl implements MetadataRowContainer {

                    private final Renderer metadataRowContainerRenderer;

                    @Data
                    public static class RendererImpl implements Renderer {

                        private final @NotNull String  trackingParams;
                        private final          Integer collapsedItemCount;
                    }
                }

                @Data
                public static class ClickableCommandImpl implements ClickableCommand {

                    private final @NotNull String       clickTrackingParams;
                    private final          ExecutorImpl commandExecutorCommand;

                    @Data
                    public static class ExecutorImpl implements Executor {

                        private final @NotNull List<CommandImpl> commands;

                        @Data
                        public static class CommandImpl implements Command {

                            private final @NotNull String                                    clickTrackingParams;
                            private final          ChangeEngagementPanelVisibilityActionImpl changeEngagementPanelVisibilityAction;

                            @Data
                            public static class ChangeEngagementPanelVisibilityActionImpl implements ChangeEngagementPanelVisibilityAction {

                                private final String targetId;
                                private final String visibility;
                            }
                        }
                    }
                }

                @Data
                public static class AttributedDescriptionImpl implements AttributedDescription {

                    private final          String          content;
                    private final @NotNull List<StyleImpl> styleRuns;
                }
            }
        }
    }
}
