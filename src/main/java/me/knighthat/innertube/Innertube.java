package me.knighthat.innertube;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.knighthat.innertube.request.Request;
import me.knighthat.innertube.request.body.RequestBody;
import me.knighthat.innertube.response.Response;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.Blocking;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public interface Provider {

        @NotNull
        @Blocking
        Response execute( Request request ) throws IOException;
    }
}
