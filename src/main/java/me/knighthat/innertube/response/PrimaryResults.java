package me.knighthat.innertube.response;

import me.knighthat.innertube.response.thumbnail.Thumbnail;
import me.knighthat.innertube.response.thumbnail.Thumbnails;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface PrimaryResults {

    Results getResults();

    interface Results {

        Contents getContents();

        interface Contents {

            VideoPrimaryInfoRenderer getVideoPrimaryInfoRenderer();

            VideoSecondaryInfoRenderer getVideoSecondaryInfoRenderer();

            interface VideoPrimaryInfoRenderer extends Trackable {

                Runs getTitle();

                ViewCount getViewCount();

                Menu getVideoActions();

                SimpleText getDateText();

                SimpleText getRelativeDateText();

                interface ViewCount {

                    VideoViewCountRenderer getVideoViewCountRenderer();

                    interface VideoViewCountRenderer {

                        SimpleText getViewCount();

                        SimpleText getShortViewCount();

                        String getOriginalViewCount();
                    }
                }
            }

            interface VideoSecondaryInfoRenderer extends Trackable {

                Owner getOwner();

                Button getSubscribeButton();

                MetadataRowContainer getMetadataRowContainer();

                SimpleText getShowMoreText();

                SimpleText getShowLessText();

                Boolean getDefaultExpanded();

                Integer getDescriptionCollapsedLines();

                ClickableCommand getShowMoreCommand();

                ClickableCommand.Executor.Command getShowLessCommand();

                AttributedDescription getAttributedDescription();

                @NotNull List<? extends Style> getHeaderRuns();

                interface Owner {

                    Thumbnail.Renderer getVideoOwnerRenderer();

                    Button.Subscribe getSubscriptionButton();

                    Endpoint getNavigationEndpoint();

                    SimpleText getSubscriberCountText();

                    @NotNull
                    List<? extends Badge> getBadges();

                    interface VideoOwnerRenderer {

                        Thumbnails getThumbnail();

                        Runs getTitle();
                    }
                }

                interface MetadataRowContainer {

                    Renderer getMetadataRowContainerRenderer();

                    interface Renderer extends Trackable {

                        Integer getCollapsedItemCount();
                    }
                }

                interface ClickableCommand extends ClickTrackable {

                    Executor getCommandExecutorCommand();

                    interface Executor {

                        @NotNull
                        List<? extends Command> getCommands();

                        interface Command extends ClickTrackable {

                            ChangeEngagementPanelVisibilityAction getChangeEngagementPanelVisibilityAction();

                            interface ChangeEngagementPanelVisibilityAction {

                                String getTargetId();

                                String getVisibility();
                            }
                        }
                    }
                }

                interface AttributedDescription {

                    String getContent();

                    @NotNull List<? extends Style> getStyleRuns();
                }
            }
        }
    }
}
