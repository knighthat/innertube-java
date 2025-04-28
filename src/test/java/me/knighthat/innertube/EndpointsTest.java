package me.knighthat.innertube;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.knighthat.innertube.request.body.*;
import okhttp3.*;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests designed to make sure that all endpoints are
 * reachable given provided data is correct and adhere
 * to YTM standard.
 */
class EndpointsTest {

    @NotNull
    private static final OkHttpClient CLIENT = new OkHttpClient();

    @NotNull
    private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();

    private boolean post( String endpoint, me.knighthat.innertube.request.body.RequestBody body ) throws JsonProcessingException {
        RequestBody reqBody = RequestBody.create( OBJ_MAPPER.writeValueAsString( body ), Constants.APPLICATION_JSON );

        HttpUrl url = HttpUrl.parse( Constants.YOUTUBE_MUSIC_HOST + "/" + endpoint )
                             .newBuilder()
                             .addQueryParameter( "prettyPrint", "false" )
                             .build();

        Request request = new Request.Builder()
                                    .url( url )
                                    .addHeader( "Content-Type", Constants.APPLICATION_JSON.type() )
                                    .addHeader( "User-Agent", UserAgents.CHROME_WINDOWS )
                                    .post( reqBody )
                                    .build();

        try (
                Response response = CLIENT.newCall( request ).execute()
        ) {
            return response.isSuccessful();
        } catch ( Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

    @Test
    void testBrowseArtist() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "UCprAFmT0C6O4X0ToEXpeFTQ", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseAlbum() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "MPREb_rGUlsaCTNv7", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseRadio() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "", "RDAMVMphLb_SoPBlA", "wAEB" );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseLyrics() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "MPLYt_4sk9YQcgV3s-1", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseMusicHome() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "FEmusic_home", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowsePlaylist() throws JsonProcessingException {
        BrowseBody browseBody = new BrowseBody( Context.WEB_DEFAULT, "VLRDCLAK5uy_k6PkYWus1Mt-aKrbb0Ne8SkA2BgAk1Yy4", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testNextSong() throws JsonProcessingException {
        NextBody nextBody = new NextBody( Context.WEB_DEFAULT, "nZjTtuNR3Og", "", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, nextBody ) );
    }

    @Test
    void testNextPlaylist() throws JsonProcessingException {
        NextBody nextBody = new NextBody( Context.WEB_DEFAULT, "", "RDAMVMnZjTtuNR3Og", "wAEB" );
        Assertions.assertTrue( post( Endpoints.BROWSE, nextBody ) );
    }

    @Test
    void testPlayer() throws JsonProcessingException {
        PlayerBody playerBody = new PlayerBody( Context.WEB_DEFAULT, "phLb_SoPBlA", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, playerBody ) );
    }

    @Test
    void testSearch() throws JsonProcessingException {
        SearchBody searchBody = new SearchBody( Context.WEB_DEFAULT, "take me to church" );
        Assertions.assertTrue( post( Endpoints.BROWSE, searchBody ) );
    }

    @Test
    void testSearchSuggestion() throws JsonProcessingException {
        SearchSuggestionsBody searchSuggestionsBody = new SearchSuggestionsBody( Context.WEB_DEFAULT, "figure 09" );
        Assertions.assertTrue( post( Endpoints.BROWSE, searchSuggestionsBody ) );
    }
}