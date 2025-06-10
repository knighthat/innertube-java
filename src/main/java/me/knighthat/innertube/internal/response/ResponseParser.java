package me.knighthat.innertube.internal.response;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class ResponseParser {

    // START: Static fields/functions
    @NotNull
    private static final Gson GSON = new GsonBuilder().registerTypeAdapterFactory( new NonNullListProcessor() )
                                                      .create();

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

    static class NonNullListProcessor implements TypeAdapterFactory {

        @Override
        public <T> TypeAdapter<T> create( @NotNull Gson gson, @NotNull TypeToken<T> typeToken ) {
            TypeAdapter<T> delegate = gson.getDelegateAdapter( this, typeToken );

            return new TypeAdapter<T>() {
                @Override
                public void write( JsonWriter jsonWriter, T t ) throws IOException {
                    delegate.write( jsonWriter, t );
                }

                @Override
                public T read( JsonReader jsonReader ) throws IOException {
                    T obj = delegate.read( jsonReader );

                    for ( Field field : obj.getClass()
                                           .getDeclaredFields() ) {
                        // Filter out List fields
                        if ( !List.class.isAssignableFrom( field.getType() ) )
                            continue;

                        try {
                            // All fields are private and final
                            // Setting this to `true` allow modification
                            field.setAccessible( true );

                            Object fieldValue = field.get( obj );
                            if ( fieldValue == null )
                                field.set( obj, Collections.emptyList() );
                        } catch ( IllegalAccessException e ) {
                            // This block should never see the light
                            throw new RuntimeException( e );
                        }
                    }

                    return obj;
                }
            };
        }
    }
}
