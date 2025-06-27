package me.knighthat.innertube;

import static me.knighthat.innertube.request.Request.POST;

import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.knighthat.innertube.internal.response.ResponseParser;
import me.knighthat.innertube.model.ContinuedPlaylist;
import me.knighthat.innertube.model.InnertubePlaylist;
import me.knighthat.innertube.request.Localization;
import me.knighthat.innertube.request.Request;
import me.knighthat.innertube.request.body.BrowseBody;
import me.knighthat.innertube.request.body.Context;
import me.knighthat.innertube.request.body.RequestBody;
import me.knighthat.innertube.response.BrowseResponse;
import me.knighthat.innertube.response.Response;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Innertube {

    // START: Static fields/functions
    @Setter
    private static Provider client;

    @Blocking
    @VisibleForTesting
    static <T extends RequestBody> @NotNull Response youtubeMusic(
            @MagicConstant(valuesFromClass = Request.class) String method,
            @MagicConstant(valuesFromClass = Endpoints.class) String endpoint,
            T requestBody,
            Map<String, List<String>> headers
    ) throws IOException {
        Request request = Request.builder()
                                 .httpMethod( method )
                                 .url( Constants.YOUTUBE_MUSIC_URL + "/" + endpoint )
                                 .headers( headers )
                                 .dataToSend( requestBody )
                                 .build();

        return client.execute( request );
    }

    @Blocking
    @VisibleForTesting
    static <T extends RequestBody> @NotNull Response youtube(
            @MagicConstant(valuesFromClass = Request.class) String method,
            @MagicConstant(valuesFromClass = Endpoints.class) String endpoint,
            T requestBody,
            Map<String, List<String>> headers
    ) throws IOException {
        Request request = Request.builder()
                                 .httpMethod( method )
                                 .url( Constants.YOUTUBE_URL + "/" + endpoint )
                                 .headers( headers )
                                 .dataToSend( requestBody )
                                 .build();

        return client.execute( request );
    }
    // END: Static fields/functions

    @Blocking
    private static @NotNull Response ytmBrowse( BrowseBody browseBody, Map<String, List<String>> headers ) throws IOException {
        return youtubeMusic( POST, Endpoints.BROWSE, browseBody, headers );
    }

    @Blocking
    public static @NotNull Optional<InnertubePlaylist> browsePlaylist(
            @NotNull String playlistId,
            @NotNull Localization localization
    ) {
        Context context = new Context(
                Context.WEB_REMIX_DEFAULT.getClient().toBuilder().localization( localization ).build()
        );
        BrowseBody browseBody = BrowseBody.builder( context )
                                          .browseId( playlistId )
                                          .build();

        try {
            Response response = ytmBrowse( browseBody, Constants.JSON_HEADERS );
            BrowseResponse browseResponse = ResponseParser.browse( response );
            BrowseResponse.Contents.TwoColumnBrowseResultsRenderer renderer = Objects.requireNonNull(
                    browseResponse.getContents()
                                  .getTwoColumnBrowseResultsRenderer()
            );
            InnertubePlaylist playlist = InnertubePlaylist.from(
                    browseResponse.getResponseContext().getVisitorData(),
                    renderer
            );

            return Optional.of( playlist );
        } catch ( IOException e ) {
            System.out.println( "Error occurs while fetching playlist " + playlistId );
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Request for more songs in a playlist.
     * <p>
     * {@code visitorData} and {@code continuation} are parameters
     * extracted from response when you browse for playlist.
     *
     * @param visitorData tracking parameter extracted from browse playlist response
     * @param continuation unique string of playlist to get next songs
     * @param params additional parameters (optional)
     */
    @Blocking
    public static @NotNull Optional<ContinuedPlaylist> playlistContinued(
            @NotNull String visitorData,
            @NotNull String continuation,
            @NotNull Localization localization,
            @Nullable String params
    ) {
        Context context = new Context(
                Context.WEB_REMIX_DEFAULT.getClient()
                                         .toBuilder()
                                         .visitorData( visitorData )
                                         .localization( localization )
                                         .build()
        );
        BrowseBody browseBody = BrowseBody.builder( context )
                                          .continuation( continuation )
                                          .params( params )
                                          .build();

        try {
            Response response = ytmBrowse( browseBody, Constants.JSON_HEADERS );
            BrowseResponse browseResponse = ResponseParser.browse( response );
            List<? extends BrowseResponse.ResponseReceivedAction> actions = Objects.requireNonNull(
                    browseResponse.getOnResponseReceivedActions()
            );
            ContinuedPlaylist continuedPlaylist = ContinuedPlaylist.from(
                    actions.get( 0 ).getAppendContinuationItemsAction().getContinuationItems()
            );

            return Optional.of( continuedPlaylist );
        } catch ( IOException e ) {
            System.out.println( "Error occurs while fetching playlist continuation" );
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public interface Provider {

        @NotNull
        @Blocking
        Response execute( Request request ) throws IOException;
    }
}
