package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.PlayerResponse;

import java.util.List;

@Value
class PlayerResponseImpl implements PlayerResponse {

    ResponseContextImpl   responseContext;
    PlayabilityStatusImpl playabilityStatus;
    StreamingDataImpl streamingData;
    VideoDetailsImpl videoDetails;
    PlayerConfigImpl playerConfig;
    MicroformatImpl  microformat;
    String           trackingParams;

    @Value
    static class PlayabilityStatusImpl implements PlayabilityStatus {

        String status;
        String reason;
        Boolean                  playableInEmbed;
        AudioOnlyPlayabilityImpl audioOnlyPlayability;
        MiniplayerImpl           miniplayer;
        String                   contextParams;

        @Value
        static class AudioOnlyPlayabilityImpl implements AudioOnlyPlayability {

            AudioOnlyPlayabilityRendererImpl audioOnlyPlayabilityRenderer;

            @Value
            static class AudioOnlyPlayabilityRendererImpl implements AudioOnlyPlayabilityRenderer {

                String trackingParams;
                String audioOnlyAvailability;
            }
        }

        @Value
        static class MiniplayerImpl implements Miniplayer {

            MiniplayerRendererImpl miniplayerRenderer;

            @Value
            static class MiniplayerRendererImpl implements MiniplayerRenderer {

                String playbackMode;
            }
        }
    }

    @Value
    static class StreamingDataImpl implements StreamingData {

        String           expiresInSeconds;
        List<FormatImpl> formats;
        List<FormatImpl> adaptiveFormats;
        String           serverAbrStreamingUrl;

        @Value
        static class FormatImpl implements Format {

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
            static class RangeImpl implements Range {

                String start;
                String end;
            }

            @Value
            static class ColorInfoImpl implements ColorInfo {

                String primaries;
                String transferCharacteristics;
                String matrixCoefficients;
            }
        }
    }

    @Value
    static class VideoDetailsImpl implements VideoDetails {

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
    static class PlayerConfigImpl implements PlayerConfig {

        AudioConfigImpl audioConfig;

        @Value
        static class AudioConfigImpl implements AudioConfig {

            Float loudnessDb;
            Float perceptualLoudnessDb;
            Boolean enablePerFormatLoudness;
        }
    }
}