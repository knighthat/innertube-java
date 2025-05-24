package me.knighthat.innertube.request.body;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

import lombok.Data;
import me.knighthat.innertube.Constants;
import me.knighthat.innertube.UserAgents;

@Data
public class Context {

    @NotNull
    public static final Context WEB_REMIX_DEFAULT = new Context( Client.WEB_REMIX );

    @NotNull
    public static final Context IOS_DEFAULT = new Context( Client.IOS );

    @NotNull
    public static final Context WEB_DEFAULT = new Context( Client.WEB );

    @NotNull
    public final Client client;

    @Data
    public static class Client {

        @NotNull
        public static final Client WEB_REMIX = new Client(
                "WEB_REMIX",
                "1.20250416.01.00",
                "DESKTOP",
                Locale.getDefault().getLanguage(),
                Locale.getDefault().getCountry(),
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
                Locale.getDefault().getLanguage(),
                Locale.getDefault().getCountry(),
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
                Locale.getDefault().getLanguage(),
                Locale.getDefault().getCountry(),
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

        /**
         * Name of client to present to YouTube,
         * can be extracted by using web interface.
         * <p>
         * Go to <a href="https://music.youtube.com">...</a> with inspector
         * and look for any POST request to "music.youtube.com",
         * "clientName" should be present in request.
         */
        @NotNull
        public final String clientName;

        /**
         * Version co-responding to {@code clientName},
         * should be extracted at the same time with it
         * to prevent version mismatch.
         */
        @NotNull
        public final String clientVersion;

        /**
         * Platform sending the request, co-response to {@code clientName}.
         */
        @NotNull
        public final String platform;

        /**
         * 2-letter language code
         * <p>
         * I.E. `en` equals `English`
         */
        @NotNull
        public final String hl;

        /**
         * 2-letter region code
         * <p>
         * I.E. `US` equals `United States`
         */
        @NotNull
        public final String gl;

        /**
         * Unique string for YT tracking. Required in most scenario.
         * <p>
         * Use {@code Constants.VISITOR_DATA} for default value.
         */
        @NotNull
        public final String visitorData;

        /**
         * Browser identifier.
         * <p>
         * Use {@code UserAgents} for default values
         */
        @Nullable
        public final String userAgent;

        /**
         * Should be <a href="https://music.youtube.com">...</a> in most cases
         */
        @Nullable
        public final String referer;

        /**
         * {@code versionName} in numeric format. Must co-response to
         * {@code versionName}.
         * <p>
         * {@code 67} is numeric format of "{@code DESKTOP}"
         */
        public final int xClientName;

        /**
         * Device's brand, shouldn't be {@code null}, but can be empty
         */
        @NotNull
        public final String deviceMake;

        /**
         * Device's model, shouldn't be {@code null}, but can be empty
         */
        @NotNull
        public final String deviceModel;

        /**
         * Device's operating system, commonly used to
         * spook mobile devices.
         * <p>
         * Shouldn't be {@code null} but can be empty.
         */
        @NotNull
        public final String osName;

        /**
         * Device's operating system's version, commonly used to
         * spook mobile devices.
         * <p>
         * Shouldn't be {@code null} but can be empty.
         */
        @NotNull
        public final String osVersion;

        /**
         * Usually {@code https://www.youtube.com/watch?v=$videoId}
         */
        @Nullable
        public final String originalUrl;

        /**
         * For content-negotiation, not required, but nice to have
         */
        @Nullable
        public final String acceptHeader;

        /**
         * Required for Android client.
         */
        @Nullable
        public final Integer androidSdkVersion;
    }
}
