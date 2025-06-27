package me.knighthat.innertube.request.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class PlayerBody implements RequestBody {

// START: Static fields/functions
    @Contract(value = "_->new", pure = true)
    public static @NotNull PlayerBody.Builder builder( @NotNull Context context ) {
        return new BuilderImpl( context );
    }
// END: Static fields/functions

    @NotNull  Context                    context;
    @NotNull  String                     videoId;
    @Nullable String                     params;
    @Nullable Boolean                    racyCheckOk;
    @Nullable Boolean                    contentCheckOk;
    @Nullable ServiceIntegrityDimensions serviceIntegrityDimensions;

    @Value
    public static class ServiceIntegrityDimensions {

        @NotNull
        String poToken;
    }

    public interface Builder {

        /**
         * Video to obtain playback URL.
         *
         * @param videoId unique ID of video
         *
         * @return {@link NextBody.Builder} for further development
         */
        @NotNull Builder videoId( @NotNull String videoId );

        /**
         * Optional, may affect result from YT/YTM
         *
         * @return {@link NextBody.Builder} for further development
         */
        @NotNull Builder params( @Nullable String params );

        /**
         * Unknown, but seems to help with the response.
         */
        @NotNull Builder racyCheckOk( boolean racyCheckOk );

        /**
         * Unknown, but seems to help with the response.
         */
        @NotNull Builder contentCheckOk( boolean contentCheckOk );

        /**
         * Although optional, adding this reduces chances of
         * blocking significantly, especially on mobile devices.
         * <p>
         * A 12-character string is all required.
         *
         * @param serviceIntegrityDimensions an instance that holds poToken
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder serviceIntegrityDimensions( @NotNull ServiceIntegrityDimensions serviceIntegrityDimensions );

        /**
         * Finalize all values.
         *
         * @return new instance if {@link PlayerBody} with provided values
         */
        @NotNull PlayerBody build();
    }

    private static class BuilderImpl implements Builder {

        @NotNull  Context                    context;
        @NotNull  String                     videoId;
        @Nullable String                     params;
        @Nullable Boolean                    racyCheckOk;
        @Nullable Boolean                    contentCheckOk;
        @Nullable ServiceIntegrityDimensions serviceIntegrityDimensions;

        public BuilderImpl( @NotNull Context context ) {
            this.context = context;
            this.params = null;
            this.racyCheckOk = true;
            this.contentCheckOk = true;
        }

        @Override
        public @NotNull Builder videoId( @NotNull String videoId ) {
            this.videoId = videoId;
            return this;
        }

        @Override
        public @NotNull Builder params( @Nullable String params ) {
            this.params = params;
            return this;
        }

        @Override
        public @NotNull Builder racyCheckOk( boolean racyCheckOk ) {
            this.racyCheckOk = racyCheckOk;
            return this;
        }

        @Override
        public @NotNull Builder contentCheckOk( boolean contentCheckOk ) {
            this.contentCheckOk = contentCheckOk;
            return this;
        }

        @Override
        public @NotNull Builder serviceIntegrityDimensions( @Nullable ServiceIntegrityDimensions serviceIntegrityDimensions ) {
            this.serviceIntegrityDimensions = serviceIntegrityDimensions;
            return this;
        }

        @Override
        public @NotNull PlayerBody build() {
            return new PlayerBody( context, videoId, params, racyCheckOk, contentCheckOk, serviceIntegrityDimensions );
        }
    }
}
