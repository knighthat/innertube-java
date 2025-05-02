package me.knighthat.innertube.response.endpoint;

public interface QueueUpdateCommand {

    String getQueueUpdateSection();

    FetchContentsCommand getFetchContentsCommand();

    Boolean getDedupeAgainstLocalQueue();

    interface FetchContentsCommand {

        String getClickTrackingParams();

        WatchEndpoint getWatchEndpoint();
    }
}