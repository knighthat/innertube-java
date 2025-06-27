package me.knighthat.innertube.request.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class SearchSuggestionsBody implements RequestBody {

// START: Static fields/functions
    @Contract(value = "_->new", pure = true)
    public static @NotNull SearchSuggestionsBody.Builder builder( @NotNull Context context ) {
        return new BuilderImpl( context );
    }
// END: Static fields/functions

    @NotNull Context context;
    @NotNull String  input;

    public interface Builder {

        /**
         * @param input what to get suggestion for
         *
         * @return {@link Builder} for further development
         */
        @NotNull Builder input( @NotNull String input );

        /**
         * Finalize all values.
         *
         * @return new instance if {@link SearchSuggestionsBody} with provided values
         */
        @NotNull SearchSuggestionsBody build();
    }

    private static class BuilderImpl implements Builder {

        Context context;
        String  input;

        public BuilderImpl( @NotNull Context context ) {
            this.context = context;
        }

        @Override
        public @NotNull Builder input( @NotNull String input ) {
            this.input = input;
            return this;
        }

        @Override
        public @NotNull SearchSuggestionsBody build() {
            assert context != null && input != null;
            return new SearchSuggestionsBody( context, input );
        }
    }
}
