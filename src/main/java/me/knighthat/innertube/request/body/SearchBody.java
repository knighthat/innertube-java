package me.knighthat.innertube.request.body;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import me.knighthat.innertube.SearchFilter;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class SearchBody implements RequestBody {

// START: Static fields/functions
    @Contract(value = "_->new", pure = true)
    public static @NotNull SearchBody.Builder builder( @NotNull Context context ) {
        return new BuilderImpl( context );
    }
// END: Static fields/functions

    @NotNull  Context context;
    @NotNull  String  query;
    @MagicConstant(valuesFromClass = SearchFilter.class)
    @Nullable String  params;

    public interface Builder {

        /**
         * @param query what to search
         *
         * @return {@link NextBody.Builder} for further development
         */
        @NotNull Builder query( @NotNull String query );

        /**
         * Mostly used to filter what type of content should be in
         * the search. Usually for search only for videos, artists, or albums, etc.
         *
         * @param params search filter
         *
         * @return {@link NextBody.Builder} for further development
         *
         * @see SearchFilter
         */
        @NotNull Builder params( @MagicConstant(valuesFromClass = SearchFilter.class) @Nullable String params );

        /**
         * Finalize all values.
         *
         * @return new instance if {@link SearchBody} with provided values
         */
        @NotNull SearchBody build();
    }

    private static class BuilderImpl implements Builder {

        @NotNull  Context context;
        @NotNull  String  query;
        @Nullable String  params;

        public BuilderImpl( @NotNull Context context ) {
            this.context = context;
            this.params = null;
        }

        @Override
        public @NotNull Builder query( @NotNull String query ) {
            this.query = query;
            return this;
        }

        @Override
        public @NotNull Builder params( @Nullable String params ) {
            this.params = params;
            return this;
        }

        @Override
        public @NotNull SearchBody build() {
            return new SearchBody( context, query, params );
        }
    }
}
