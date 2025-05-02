package me.knighthat.innertube.response.endpoint;

public interface WatchEndpoint {

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

        VssLoggingContext getVssLoggingContext();

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