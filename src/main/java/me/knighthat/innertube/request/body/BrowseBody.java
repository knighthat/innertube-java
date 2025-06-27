package me.knighthat.innertube.request.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class BrowseBody implements RequestBody {

    // START: Static fields/functions
    @Contract(value = "_->new", pure = true)
    public static @NotNull TypeBuilder builder( @NotNull Context context ) {
        return new TypeBuilderImpl( context );
    }
    // END: Static fields/functions

    @NotNull  Context context;
    @Nullable String  browseId;
    @Nullable String  params;
    @Nullable String  continuation;
    @Nullable String  playlistId;         // FIXME: This "entry" doesn't exist

    public interface Builder {

        /**
         * Optional, may affect result from YT/YTM
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder params( @Nullable String params );

        /**
         * Finalize all values.
         *
         * @return new instance if {@link BrowseBody} with provided values
         */
        @NotNull BrowseBody build();
    }

    public interface TypeBuilder {

        /**
         * Used to search for a specific playlist, album, or artist.
         *
         * @param browseId unique id of album, artist, or a playlist
         *
         * @return {@link Builder} to set params or to build
         */
        @NotNull Builder browseId( @NotNull String browseId );

        /**
         * Used to get related songs, topics, moods, etc.
         *
         * @param playlistId unique ID of song or playlist
         *
         * @return {@link Builder} to set params or to build
         */
        @NotNull Builder playlistId( @NotNull String playlistId );

        /**
         * Used to retrieve next songs of a playlist.
         *
         * @param continuation unique string to get next songs from a playlist
         *
         * @return {@link Builder} to set params or to build
         */
        @NotNull Builder continuation( @NotNull String continuation );
    }

    private static class TypeBuilderImpl implements Builder, TypeBuilder {

        Context context;
        String  browseId;
        String  playlistId;
        String  params;
        String  continuation;

        TypeBuilderImpl( @NotNull Context context ) {
            this.context = context;
            browseId = null;
            playlistId = null;
            params = null;
            continuation = null;
        }

        @Override
        public @NotNull Builder params( @Nullable String params ) {
            this.params = params;
            return this;
        }

        @Override
        public @NotNull Builder browseId( @NotNull String browseId ) {
            this.browseId = browseId;
            return this;
        }

        @Override
        public @NotNull Builder playlistId( @NotNull String playlistId ) {
            this.playlistId = playlistId;
            return this;
        }

        @Override
        public @NotNull Builder continuation( @NotNull String continuation ) {
            this.continuation = continuation;
            return this;
        }

        @Override
        public @NotNull BrowseBody build() {
            assert context != null;
            // Either 1 of these 3 is not null
            assert browseId != null || playlistId != null || continuation != null;
            return new BrowseBody( context, browseId, playlistId, params, continuation );
        }
    }
}
