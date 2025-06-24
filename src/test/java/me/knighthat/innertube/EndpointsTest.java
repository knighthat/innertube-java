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
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "UCprAFmT0C6O4X0ToEXpeFTQ", "", null, null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseAlbum() {
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "MPREb_rGUlsaCTNv7", "", null, null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseRadio() {
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "", "RDAMVMphLb_SoPBlA", "wAEB", null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseLyrics() {
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "MPLYt_4sk9YQcgV3s-1", "", null, null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowseMusicHome() {
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "FEmusic_home", "", null, null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testBrowsePlaylist() {
        BrowseBody browseBody = new BrowseBody( Context.WEB_REMIX_DEFAULT, "VLRDCLAK5uy_k6PkYWus1Mt-aKrbb0Ne8SkA2BgAk1Yy4", "", null, null );
        Assertions.assertTrue( post( Endpoints.BROWSE, browseBody ) );
    }

    @Test
    void testNextSongOnWebRemix() {
        NextBody nextBody = new NextBody( Context.WEB_REMIX_DEFAULT, "nZjTtuNR3Og", "", null );
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testNextSongOnWeb() {
        NextBody nextBody = new NextBody( Context.WEB_DEFAULT, "nZjTtuNR3Og", "", null );
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testNextPlaylist() {
        NextBody nextBody = new NextBody( Context.WEB_REMIX_DEFAULT, "", "RDAMVMnZjTtuNR3Og", "wAEB" );
        Assertions.assertTrue( post( Endpoints.NEXT, nextBody ) );
    }

    @Test
    void testPlayer() {
        PlayerBody playerBody = new PlayerBody( Context.WEB_REMIX_DEFAULT, "phLb_SoPBlA", null, true, true, null );
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