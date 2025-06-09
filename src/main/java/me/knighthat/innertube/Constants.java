package me.knighthat.innertube;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Constants {

    // START: Static fields/functions
    @NotNull
    public static final String VISITOR_DATA = "CgtMN0FkbDFaWERfdyi8t4u7BjIKCgJWThIEGgAgWQ%3D%3D";

    @NotNull
    public static final String YOUTUBE_MUSIC_URL = "https://music.youtube.com";

    @NotNull
    public static final String YOUTUBE_URL = "https://www.youtube.com";

    @NotNull
    public static final String ACCEPT_HEADERS = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";

    @NotNull
    public static final Map<String, List<String>> JSON_HEADERS = Map.of(
            "Content-Type", List.of( "application/json" ),
            "Accept-Encoding", List.of( "gzip", "deflate" ),
            "Content-Encoding", List.of( "gzip" ),
            "User-Agent", List.of( UserAgents.CHROME_WINDOWS )
    );
    // END: Static fields/functions

    private Constants() {}
}
