package me.knighthat.innertube.internal.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import me.knighthat.innertube.response.BrowseResponse;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import me.knighthat.innertube.response.PlaylistPanelRenderer;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;

/**
 * Granular parsers
 */
public class GranularParser {

// START: Static fields/functions
    @NotNull
    private static final Gson GSON = new GsonBuilder().registerTypeAdapterFactory( new ResponseParser.NonNullListProcessor() )
                                                      .create();

    public static @NotNull MusicResponsiveListItemRenderer musicResponsiveListItemRenderer( @NotNull InputStreamReader reader ) throws JsonSyntaxException {
        return GSON.fromJson( reader, MusicResponsiveListItemRendererImpl.class );
    }

    public static PlaylistPanelRenderer.Content.VideoRenderer playlistPanelVideoRenderer( @NotNull InputStreamReader reader ) throws JsonSyntaxException {
        return GSON.fromJson( reader, PlaylistPanelRendererImpl.ContentImpl.VideoRendererImpl.class );
    }

    public static MusicTwoRowItemRenderer musicTwoRowItemRenderer( @NotNull InputStreamReader reader ) throws JsonSyntaxException {
        return GSON.fromJson( reader, MusicTwoRowItemRendererImpl.class );
    }

    public static BrowseResponse.Contents.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer( @NotNull InputStreamReader reader ) {
        return GSON.fromJson( reader, BrowseResponseImpl.ContentsImpl.TwoColumnBrowseResultsRendererImpl.class );
    }

    public static BrowseResponse browseResponse( @NotNull InputStreamReader reader ) {
        return GSON.fromJson( reader, BrowseResponseImpl.class );
    }
// END: Static fields/functions
}
