package me.knighthat.innertube.response.endpoint;

public interface Endpoint {

    String getClickTrackingParams();

    BrowseEndpoint getBrowseEndpoint();

    WatchEndpoint getWatchEndpoint();

    ModalEndpoint getModalEndpoint();

    WatchPlaylistEndpoint getWatchPlaylistEndpoint();

    QueueEndpoint.QueueAdd    getQueueAddEndpoint();

    QueueEndpoint.QueueRemove getRemoveFromQueueEndpoint();

    LikeEndpoint getLikeEndpoint();

    ShareEntityEndpoint getShareEntityEndpoint();

    SearchEndpoint getSearchEndpoint();

    SignInEndpoint getSignInEndpoint();

    FeedbackEndpoint getFeedbackEndpoint();

    PlaylistEditEndpoint getPlaylistEditEndpoint();

    QueueUpdateCommand getQueueUpdateCommand();
}