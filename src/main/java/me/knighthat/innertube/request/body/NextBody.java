package me.knighthat.innertube.request.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class NextBody implements RequestBody {
    // FIXME: Missing continuation to get related songs in "Up next"

    // START: Static fields/functions
    @Contract(value = "_->new", pure = true)
    public static @NotNull NextBody.Builder builder( @NotNull Context context ) {
        return new NextBody.BuilderImpl( context );
    }
// END: Static fields/functions

    @NotNull  Context context;
    @Nullable String  videoId;
    @Nullable String  playlistId;
    @Nullable String  params;

    public interface Builder {

        /**
         * Can be used to retrieve related songs.
         * <p>
         * Combining with {@code continuation} string to achieve
         * more related songs
         *
         * @param videoId unique ID of a song
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder videoId( @Nullable String videoId );

        /**
         * Can be used along with {@code videoId} and {@code continuation}
         * to retrieve songs of initial song and overall genre of a playlist.
         *
         * @param playlistId unique ID of a playlist
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder playlistId( @Nullable String playlistId );

        /**
         * Optional, may affect result from YT/YTM
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder params( @Nullable String params );

        /**
         * Finalize all values.
         *
         * @return new instance if {@link NextBody} with provided values
         */
        @NotNull NextBody build();
    }

    private static class BuilderImpl implements Builder {

        Context context;
        String  videoId;
        String  playlistId;
        String  params;

        public BuilderImpl( @NotNull Context context ) {
            this.context = context;
            this.videoId = null;
            this.playlistId = null;
            this.params = null;
        }

        @Override
        public @NotNull Builder videoId( @Nullable String videoId ) {
            this.videoId = videoId;
            return this;
        }

        @Override
        public @NotNull Builder playlistId( @Nullable String playlistId ) {
            this.playlistId = playlistId;
            return this;
        }

        @Override
        public @NotNull Builder params( @Nullable String params ) {
            this.params = params;
            return this;
        }

        @Override
        public @NotNull NextBody build() {
            assert context != null;
            // Either of them must be a non-null value
            assert videoId != null || playlistId != null;
            return new NextBody( context, videoId, playlistId, params );
        }
    }
}
