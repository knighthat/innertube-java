package me.knighthat.innertube.internal.response;

import me.knighthat.innertube.Endpoints;
import me.knighthat.innertube.HttpClient;
import me.knighthat.innertube.request.body.BrowseBody;
import me.knighthat.innertube.request.body.Context;
import me.knighthat.innertube.response.BrowseResponse;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BrowseResponseTest implements HttpClient {

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchMusicHome() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "FEmusic_home" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchRadio() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "RDAMVMphLb_SoPBlA" )
                                          .params( "wAEB" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchAlbum() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "MPREb_rGUlsaCTNv7" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchArtist() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "UCprAFmT0C6O4X0ToEXpeFTQ" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchArtistAlbum() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "MPADUCprAFmT0C6O4X0ToEXpeFTQ" )
                                          .params( "ggMIegYIAhoCAQI%3D" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     *
     * FIXME: Wrong body, [BrowseBody.playlistId] doesn't exist
     */
    @Test
    void testFetchArtistSongs() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "UCprAFmT0C6O4X0ToEXpeFTQ" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchLyrics() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .browseId( "MPLYt_4sk9YQcgV3s-1" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "browse" endpoint and convert it into {@link BrowseResponse}
     */
    @Test
    void testFetchPlaylist() {
        BrowseBody searchBody = BrowseBody.builder( Context.WEB_REMIX_DEFAULT )
                                          .playlistId( "VLRDCLAK5uy_lc4yBYpywmmgjplkuzYxzUgLJ8UvDKUUk" )
                                          .build();
        Request request = makeRequest( Endpoints.BROWSE, searchBody );

        try (
                Response response = CLIENT.newCall( request ).execute() ;
                InputStream inStream = response.body().byteStream() ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            BrowseResponse converted = JSON.fromJson( reader, BrowseResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }
}