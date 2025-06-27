package me.knighthat.innertube.internal.response;

import me.knighthat.innertube.Endpoints;
import me.knighthat.innertube.HttpClient;
import me.knighthat.innertube.request.body.Context;
import me.knighthat.innertube.request.body.NextBody;
import me.knighthat.innertube.response.NextResponse;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NextResponseTest implements HttpClient {

    /**
     * Fetch data from "next" endpoint and convert it into {@link NextResponse}
     */
    @Test
    void testFetchNextSong() {
        NextBody nextBody = NextBody.builder( Context.WEB_REMIX_DEFAULT )
                                    .videoId( "nZjTtuNR3Og" )
                                    .build();
        Request request = makeRequest( Endpoints.NEXT, nextBody );

        try (
                Response response = CLIENT.newCall( request ).execute();
                InputStream inStream = response.body().byteStream();
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            NextResponse converted = JSON.fromJson( reader, NextResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }

    /**
     * Fetch data from "next" endpoint and convert it into {@link NextResponse}
     */
    @Test
    void testFetchNextPlaylist() {
        NextBody nextBody = NextBody.builder( Context.WEB_REMIX_DEFAULT )
                                    .playlistId( "RDAMVM10H_LmJsb4M" )
                                    .build();
        Request request = makeRequest( Endpoints.NEXT, nextBody );

        try (
                Response response = CLIENT.newCall( request ).execute();
                InputStream inStream = response.body().byteStream();
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            assertTrue( response.isSuccessful() );

            NextResponse converted = JSON.fromJson( reader, NextResponseImpl.class );
            System.out.println( JSON.toJson( converted ) );
        } catch ( Exception e ) {
            e.printStackTrace();
            Assertions.fail( e.getMessage() );
        }
    }
}