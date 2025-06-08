package me.knighthat.innertube.request.body;

import lombok.Value;
import me.knighthat.innertube.SearchFilter;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
public class SearchBody implements RequestBody {

    @NotNull
    Context context;
    @NotNull
    String  query;
    @Nullable
    @MagicConstant(valuesFromClass = SearchFilter.class)
    String  params;
}
