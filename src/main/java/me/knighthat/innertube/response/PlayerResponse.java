package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

import me.knighthat.innertube.response.thumbnail.Thumbnails;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface PlayerResponse extends Trackable {

    @NotNull
    ResponseContext getResponseContext();

    @NotNull
    PlayabilityStatus getPlayabilityStatus();

    @Nullable
    StreamingData getStreamingData();

    @Nullable
    VideoDetails getVideoDetails();

    @Nullable
    PlayerConfig getPlayerConfig();

    @Nullable
    Microformat getMicroformat();

    interface PlayabilityStatus {

        @NotNull
        String getStatus();

        @Nullable
        String getReason();

        @NotNull
        Boolean getPlayableInEmbed();

        @Nullable
        AudioOnlyPlayability getAudioOnlyPlayability();

        @Nullable
        Miniplayer getMiniplayer();

        @Nullable
        String getContextParams();

        interface AudioOnlyPlayability {

            @NotNull
            AudioOnlyPlayabilityRenderer getAudioOnlyPlayabilityRenderer();

            interface AudioOnlyPlayabilityRenderer extends Trackable {

                @NotNull
                String getAudioOnlyAvailability();
            }
        }

        interface Miniplayer {

            @NotNull
            MiniplayerRenderer getMiniplayerRenderer();

            interface MiniplayerRenderer {

                @NotNull
                String getPlaybackMode();
            }
        }
    }

    interface StreamingData {

        @NotNull
        String getExpiresInSeconds();

        @NotNull
        List<? extends Format> getFormats();

        @NotNull
        List<? extends Format> getAdaptiveFormats();

        @Nullable
        String getServerAbrStreamingUrl();

        interface Format {

            @NotNull
            Short getItag();

            @Nullable
            String getUrl();

            @NotNull
            String getMimeType();

            @NotNull
            Integer getBitrate();

            @NotNull
            Short getWidth();

            @NotNull
            Short getHeight();

            @Nullable
            Range getInitRange();

            @Nullable
            Range getIndexRange();

            @NotNull
            String getLastModified();

            @Nullable
            String getContentLength();

            @NotNull
            String getQuality();

            @NotNull
            Byte getFps();

            @NotNull
            String getQualityLabel();

            @NotNull
            String getProjectionType();

            @Nullable
            Integer getAverageBitrate();

            @Nullable
            ColorInfo getColorInfo();

            @Nullable
            Boolean getHighReplication();

            @NotNull
            String getAudioQuality();

            @NotNull
            String getApproxDurationMs();

            @NotNull
            String getAudioSampleRate();

            @NotNull
            Byte getAudioChannels();

            @Nullable
            Float getLoudnessDb();

            @Nullable
            String getSignatureCipher();

            interface Range {

                @NotNull
                String getStart();

                @NotNull
                String getEnd();
            }

            interface ColorInfo {

                @NotNull
                String getPrimaries();

                @NotNull
                String getTransferCharacteristics();

                @NotNull
                String getMatrixCoefficients();
            }
        }
    }

    interface VideoDetails {

        @NotNull
        String getVideoId();

        @NotNull
        String getTitle();

        @NotNull
        String getLengthSeconds();

        @NotNull
        String getChannelId();

        @NotNull
        Boolean getIsOwnerViewing();

        @NotNull
        Boolean getIsCrawlable();

        @NotNull
        Thumbnails getThumbnail();

        @NotNull
        Boolean getAllowRatings();

        @NotNull
        String getViewCount();

        @NotNull
        String getAuthor();

        @NotNull
        Boolean getIsPrivate();

        @NotNull
        Boolean getIsUnpluggedCorpus();

        @NotNull
        String getMusicVideoType();

        @NotNull
        Boolean getIsLiveContent();
    }

    interface PlayerConfig {

        @NotNull
        AudioConfig getAudioConfig();

        interface AudioConfig {

            @NotNull
            Float getLoudnessDb();

            @NotNull
            Float getPerceptualLoudnessDb();

            @Nullable
            Boolean getEnablePerFormatLoudness();
        }
    }
}