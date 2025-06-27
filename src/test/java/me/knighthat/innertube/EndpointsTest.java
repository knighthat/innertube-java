package me.knighthat.innertube;

import me.knighthat.innertube.request.body.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests designed to make sure that all endpoints are
 * reachable given provided data is correct and adhere
 * to YTM standard.
 */
class EndpointsTest implements HttpClient {

    @Test
    void testBrowseArtist() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "UCprAFmT0C6O4X0ToEXpeFTQ" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseAlbum() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "MPREb_rGUlsaCTNv7" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseRadio() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "RDAMVMphLb_SoPBlA" )
                                          .params( "wAEB" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseLyrics() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "MPLYt_4sk9YQcgV3s-1" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseMusicHome() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "FEmusic_home" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowsePlaylist() {
        BrowseBody browseBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "VLRDCLAK5uy_k6PkYWus1Mt-aKrbb0Ne8SkA2BgAk1Yy4" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testNextSongOnWebRemix() {
        NextBody nextBody = NextBody.builder( Context.WEB_REMIX_DEFAULT )
                                    .videoId( "nZjTtuNR3Og" )
                                    .build();
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testNextSongOnWeb() {
        NextBody nextBody = NextBody.builder( Context.WEB_DEFAULT )
                                    .videoId( "nZjTtuNR3Og" )
                                    .build();
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testNextPlaylist() {
        NextBody nextBody = NextBody.builder( Context.WEB_REMIX_DEFAULT )
                                    .playlistId( "RDAMVMnZjTtuNR3Og" )
                                    .params( "wAEB" )
                                    .build();
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testPlayer() {
        PlayerBody playerBody = PlayerBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .videoId( "phLb_SoPBlA" )
                                          .build();
        Assertions.assertTrue( post( Endpoints.PLAYER, playerBody ) );
    }

    @Test
    void testSearch() {
        SearchBody searchBody = new SearchBody( Context.WEB_REMIX_DEFAULT, "take me to church", null );
        Assertions.assertTrue( post( Endpoints.SEARCH, searchBody ) );
    }

    @Test
    void testSearchSuggestion() {
        SearchSuggestionsBody searchSuggestionsBody = new SearchSuggestionsBody( Context.WEB_REMIX_DEFAULT, "figure 09" );
        Assertions.assertTrue( post( Endpoints.SEARCH_SUGGESTIONS, searchSuggestionsBody ) );
    }
}