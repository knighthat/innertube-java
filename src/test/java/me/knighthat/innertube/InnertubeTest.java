package me.knighthat.innertube;

import me.knighthat.Constants;
import me.knighthat.innertube.request.Request;
import me.knighthat.innertube.request.body.Context;
import me.knighthat.innertube.request.body.NextBody;
import me.knighthat.innertube.request.body.SearchSuggestionsBody;
import me.knighthat.innertube.response.Response;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

class InnertubeTest {

    // START: Static fields/functions
    @BeforeAll
    static void setup() {
        Innertube.setClient( new InnertubeProvider() );
    }
    // END: Static fields/functions

    @Test
    void testYouTube() {
        // Fabricating & sending request within [Assertions.assertDoesNotThrow]
        // to avoid try/catch
        Response response = Assertions.assertDoesNotThrow( () -> {
            NextBody body = NextBody.builder( Context.WEB_DEFAULT )
                                    .videoId( "lYBUbBu4W08" )
                                    .build();
            return Innertube.youtube(
                    Request.POST, Endpoints.NEXT, body, me.knighthat.innertube.Constants.JSON_HEADERS
            );
        } );

        Assertions.assertEquals( 200, response.getResponseCode() );
        Assertions.assertFalse( response.getResponseBody().isEmpty() );
    }

    @Test
    void testYouTubeMusic() {
        Response response = Assertions.assertDoesNotThrow( () -> {
            SearchSuggestionsBody body = new SearchSuggestionsBody( Context.WEB_REMIX_DEFAULT, "million dollar baby" );
            return Innertube.youtubeMusic(
                    Request.POST, Endpoints.SEARCH_SUGGESTIONS, body, me.knighthat.innertube.Constants.JSON_HEADERS
            );
        } );

        Assertions.assertEquals( 200, response.getResponseCode() );
        Assertions.assertFalse( response.getResponseBody().isEmpty() );
    }

    private static class InnertubeProvider implements Innertube.Provider, HttpClient {

        @Override
        public @NotNull Response execute( Request request ) throws IOException {
            okhttp3.Request.Builder builder = new okhttp3.Request.Builder();

            // Add headers
            for ( Map.Entry<String, List<String>> entry : request.getHeaders().entrySet() ) {
                String valueStr = String.join( ", ", entry.getValue() );
                builder = builder.addHeader( entry.getKey(), valueStr );
            }

            // Destination (with prettyPrint turned off)
            HttpUrl url = HttpUrl.parse( request.getUrl() )
                                 .newBuilder()
                                 .addQueryParameter( "prettyPrint", "false" )
                                 .build();
            builder = builder.url( url );

            // Add method and payload (body)
            switch ( request.getHttpMethod() ) {
                case Request.GET:
                    builder = builder.get();
                    break;
                case Request.POST:
                    RequestBody requestBody = RequestBody.create( JSON.toJson( request.getDataToSend() ), Constants.APPLICATION_JSON );
                    builder = builder.post( requestBody );
                    break;
                default:
                    break;
            }

            Response result;
            try (
                    okhttp3.Response response = CLIENT.newCall( builder.build() )
                                                      .execute() ;
                    GZIPInputStream gis = new GZIPInputStream( response.body().byteStream() ) ;
                    InputStreamReader isr = new InputStreamReader( gis, StandardCharsets.UTF_8 ) ;
                    BufferedReader br = new BufferedReader( isr )
            ) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ( (line = br.readLine()) != null ) {
                    sb.append( line ).append( "\n" );
                }

                result = new Response(
                        response.code(), response.message(), response.headers().toMultimap(), sb.toString()
                );
            }

            return result;
        }
    }
}