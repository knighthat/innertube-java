package me.knighthat.innertube;

import org.jetbrains.annotations.NotNull;

public class Endpoints {

    // START: Static fields/functions
    @NotNull
    private static final String YOUTUBEI = "youtubei/v1";

    @NotNull
    public static final String BROWSE             = YOUTUBEI + "/browse";
    @NotNull
    public static final String NEXT               = YOUTUBEI + "/next";
    @NotNull
    public static final String PLAYER             = YOUTUBEI + "/player";
    @NotNull
    public static final String SEARCH             = YOUTUBEI + "/search";
    @NotNull
    public static final String SEARCH_SUGGESTIONS = YOUTUBEI + "/music/get_search_suggestions";
    // END: Static fields/functions

    private Endpoints() { }
}
