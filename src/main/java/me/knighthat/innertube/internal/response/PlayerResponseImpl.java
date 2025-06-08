package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.PlayerResponse;

import java.util.List;

@Value
public class PlayerResponseImpl implements PlayerResponse {

    ResponseContextImpl   responseContext;
    PlayabilityStatusImpl playabilityStatus;
    StreamingDataImpl streamingData;
    VideoDetailsImpl videoDetails;
    PlayerConfigImpl playerConfig;
    MicroformatImpl  microformat;
    String           trackingParams;

    @Value
    public static class PlayabilityStatusImpl implements PlayabilityStatus {

        String status;
        String reason;
        Boolean                  playableInEmbed;
        AudioOnlyPlayabilityImpl audioOnlyPlayability;
        MiniplayerImpl           miniplayer;
        String                   contextParams;

        @Value
        public static class AudioOnlyPlayabilityImpl implements AudioOnlyPlayability {

            AudioOnlyPlayabilityRendererImpl audioOnlyPlayabilityRenderer;

            @Value
            public static class AudioOnlyPlayabilityRendererImpl implements AudioOnlyPlayabilityRenderer {

                String trackingParams;
                String audioOnlyAvailability;
            }
        }

        @Value
        public static class MiniplayerImpl implements Miniplayer {

            MiniplayerRendererImpl miniplayerRenderer;

            @Value
            public static class MiniplayerRendererImpl implements MiniplayerRenderer {

                String playbackMode;
            }
        }
    }

    @Value
    public static class StreamingDataImpl implements StreamingData {

        String           expiresInSeconds;
        List<FormatImpl> formats;
        List<FormatImpl> adaptiveFormats;
        String           serverAbrStreamingUrl;

        @Value
        public static class FormatImpl implements Format {

            Short itag;
            String url;
            String mimeType;
            Integer bitrate;
            Short width;
            Short     height;
            RangeImpl initRange;
            RangeImpl indexRange;
            String    lastModified;
            String contentLength;
            String quality;
            Byte fps;
            String qualityLabel;
            String projectionType;
            Integer       averageBitrate;
            ColorInfoImpl colorInfo;
            Boolean       highReplication;
            String audioQuality;
            String approxDurationMs;
            String audioSampleRate;
            Byte audioChannels;
            Float loudnessDb;
            String signatureCipher;

            @Value
            public static class RangeImpl implements Range {

                String start;
                String end;
            }

            @Value
            public static class ColorInfoImpl implements ColorInfo {

                String primaries;
                String transferCharacteristics;
                String matrixCoefficients;
            }
        }
    }

    @Value
    public static class VideoDetailsImpl implements VideoDetails {

        String videoId;
        String title;
        String lengthSeconds;
        String channelId;
        Boolean isOwnerViewing;
        Boolean        isCrawlable;
        ThumbnailsImpl thumbnail;
        Boolean        allowRatings;
        String viewCount;
        String author;
        Boolean isPrivate;
        Boolean isUnpluggedCorpus;
        String musicVideoType;
        Boolean isLiveContent;
    }

    @Value
    public static class PlayerConfigImpl implements PlayerConfig {

        AudioConfigImpl audioConfig;

        @Value
        public static class AudioConfigImpl implements AudioConfig {

            Float loudnessDb;
            Float perceptualLoudnessDb;
            Boolean enablePerFormatLoudness;
        }
    }
}