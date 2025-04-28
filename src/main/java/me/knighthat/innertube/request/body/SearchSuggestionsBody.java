package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class SearchSuggestionsBody implements RequestBody {

    @NotNull
    public final Context context;
    @NotNull
    public final String input;
}
