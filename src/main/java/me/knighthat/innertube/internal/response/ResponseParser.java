package me.knighthat.innertube.internal.response;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;

public class ResponseParser {

// START: Static fields/functions
    @NotNull
    private static final Gson GSON = new Gson();

    public static BrowseResponse browse( @NotNull Response response ) throws JsonSyntaxException {
        return GSON.fromJson( response.getResponseBody(), BrowseResponseImpl.class );
    }

    public static NextResponse next( @NotNull Response response ) throws JsonSyntaxException {
        return GSON.fromJson( response.getResponseBody(), NextResponseImpl.class );
    }

    public static PlayerResponse player( @NotNull Response response ) throws JsonSyntaxException {
        return GSON.fromJson( response.getResponseBody(), PlayerResponseImpl.class );
    }

    public static SearchResponse search( @NotNull Response response ) throws JsonSyntaxException {
        return GSON.fromJson( response.getResponseBody(), SearchResponseImpl.class );
    }

    public static SearchSuggestionsResponse searchSuggestions( @NotNull Response response ) throws JsonSyntaxException {
        return GSON.fromJson( response.getResponseBody(), SearchSuggestionsResponseImpl.class );
    }
// END: Static fields/functions

    private ResponseParser() { }
}
