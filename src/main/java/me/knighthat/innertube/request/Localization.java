package me.knighthat.innertube.request;

import lombok.Value;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

@Value
public class Localization {

// START: Static fields/functions
    public static final @NotNull Localization EN_US = new Localization( "en", "US" );
// END: Static fields/functions

    /**
     * Language to be received by YT/YTM.
     * <p>
     * Must follow <a href="https://tools.ietf.org/html/bcp47">BCP 47</a>
     * standard (i.e. en, en-US, etc)
     */
    @Pattern(value = "^[a-z]{2,3}(-[A-Z]{2})?$")
    @NotNull String languageCode;

    /**
     * Region of requester.
     * <p>
     * Can be used to access trending songs, playlists form a specific region
     * <p>
     * Must follow <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
     * standard - 2-letter country code (i.e. US, VN, FR, etc.)
     */
    @Pattern(value = "^[A-Z]{2}$")
    @NotNull String regionCode;
}
