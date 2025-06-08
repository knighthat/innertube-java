package me.knighthat.innertube.request.body;

import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class SearchSuggestionsBody implements RequestBody {

    @NotNull
    Context context;
    @NotNull
    String  input;
}
