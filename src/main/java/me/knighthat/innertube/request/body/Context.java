package me.knighthat.innertube.request.body;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import me.knighthat.innertube.Constants;
import me.knighthat.innertube.UserAgents;
import me.knighthat.innertube.request.Localization;

@Value
public class Context {

    @NotNull
    public static final Context WEB_REMIX_DEFAULT = new Context( Client.WEB_REMIX );

    @NotNull
    public static final Context IOS_DEFAULT = new Context( Client.IOS );

    @NotNull
    public static final Context WEB_DEFAULT = new Context( Client.WEB );

    @NotNull
    Client client;

    @Value
    @Builder(toBuilder = true)
    @AllArgsConstructor
    public static class Client {

// START: Static fields/functions
        @NotNull
        public static final Client WEB_REMIX = new Client(
                "WEB_REMIX",
                "1.20250416.01.00",
                "DESKTOP",
                Localization.EN_US,
                Constants.VISITOR_DATA,
                UserAgents.CHROME_WINDOWS,
                Constants.YOUTUBE_MUSIC_URL,
                67,
                "",
                "",
                "",
                "",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                Constants.ACCEPT_HEADERS,
                null
        );

        @NotNull
        public static final Client IOS = new Client(
                "IOS",
                "20.14.2",
                "MOBILE",
                Localization.EN_US,
                Constants.VISITOR_DATA,
                UserAgents.IOS,
                Constants.YOUTUBE_MUSIC_URL,
                5,
                "Apple",
                "iPhone15,4",
                "iOS",
                "17.4.1.21E237",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                Constants.ACCEPT_HEADERS,
                null
        );

        @NotNull
        public static final Client WEB = new Client(
                "WEB",
                "2.20250523.01.00",
                "DESKTOP",
                Localization.EN_US,
                Constants.VISITOR_DATA,
                UserAgents.CHROME_WINDOWS,
                Constants.YOUTUBE_URL,
                1,
                "",
                "",
                "Windows",
                "",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                Constants.ACCEPT_HEADERS,
                null
        );
// END: Static fields/functions

        /**
         * Name of client to present to YouTube,
         * can be extracted by using web interface.
         * <p>
         * Go to <a href="https://music.youtube.com">...</a> with inspector
         * and look for any POST request to "music.youtube.com",
         * "clientName" should be present in request.
         */
        @NotNull
        String clientName;

        /**
         * Version co-responding to {@code clientName},
         * should be extracted at the same time with it
         * to prevent version mismatch.
         */
        @NotNull
        String clientVersion;

        /**
         * Platform sending the request, co-response to {@code clientName}.
         */
        @NotNull
        String platform;

        /**
         * Stands for {@code host language}, used to tell YT/YTM
         * in which the response to be.
         * <p>
         * Must follow <a href="https://tools.ietf.org/html/bcp47">BCP 47</a>
         * standard (i.e. en, en-US, etc)
         * <p>
         * I.E. `en` equals `English`
         */
        @NotNull
        String hl;

        /**
         * Stands for {@code geolocation}.
         * <p>
         * Can be used to access trending songs, playlists form a specific region
         * <p>
         * Must follow <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
         * standard - 2-letter country code (i.e. US, VN, FR, etc.)
         */
        @NotNull
        String gl;

        /**
         * Unique string for YT tracking. Required in most scenario.
         * <p>
         * Use {@code Constants.VISITOR_DATA} for default value.
         */
        @NotNull
        String visitorData;

        /**
         * Browser identifier.
         * <p>
         * Use {@code UserAgents} for default values
         */
        @Nullable
        String userAgent;

        /**
         * Should be <a href="https://music.youtube.com">...</a> in most cases
         */
        @Nullable
        String referer;

        /**
         * {@code versionName} in numeric format. Must co-response to
         * {@code versionName}.
         * <p>
         * {@code 67} is numeric format of "{@code DESKTOP}"
         */
        int xClientName;

        /**
         * Device's brand, shouldn't be {@code null}, but can be empty
         */
        @NotNull
        String deviceMake;

        /**
         * Device's model, shouldn't be {@code null}, but can be empty
         */
        @NotNull
        String deviceModel;

        /**
         * Device's operating system, commonly used to
         * spook mobile devices.
         * <p>
         * Shouldn't be {@code null} but can be empty.
         */
        @NotNull
        String osName;

        /**
         * Device's operating system's version, commonly used to
         * spook mobile devices.
         * <p>
         * Shouldn't be {@code null} but can be empty.
         */
        @NotNull
        String osVersion;

        /**
         * Usually {@code https://www.youtube.com/watch?v=$videoId}
         */
        @Nullable
        String originalUrl;

        /**
         * For content-negotiation, not required, but nice to have
         */
        @Nullable
        String acceptHeader;

        /**
         * Required for Android client.
         */
        @Nullable
        Integer androidSdkVersion;

        public Client(
                @NotNull String clientName,
                @NotNull String clientVersion,
                @NotNull String platform,
                @NotNull Localization localization,
                @NotNull String visitorData,
                @Nullable String userAgent,
                @Nullable String referer,
                int xClientName,
                @NotNull String deviceMake,
                @NotNull String deviceModel,
                @NotNull String osName,
                @NotNull String osVersion,
                @Nullable String originalUrl,
                @Nullable String acceptHeader,
                @Nullable Integer androidSdkVersion
        ) {
            this.clientName = clientName;
            this.clientVersion = clientVersion;
            this.platform = platform;
            this.hl = localization.getLanguageCode();
            this.gl = localization.getRegionCode();
            this.visitorData = visitorData;
            this.userAgent = userAgent;
            this.referer = referer;
            this.xClientName = xClientName;
            this.deviceMake = deviceMake;
            this.deviceModel = deviceModel;
            this.osName = osName;
            this.osVersion = osVersion;
            this.originalUrl = originalUrl;
            this.acceptHeader = acceptHeader;
            this.androidSdkVersion = androidSdkVersion;
        }

        public static class ClientBuilder {

            public @NotNull ClientBuilder localization( @NotNull Localization localization ) {
                this.hl = localization.getLanguageCode();
                this.gl = localization.getRegionCode();
                return this;
            }
        }
    }
}
