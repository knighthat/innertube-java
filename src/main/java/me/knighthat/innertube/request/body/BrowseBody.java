package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class BrowseBody {

    @NotNull
    public final Context.Client client;
    @NotNull
    public final String browseId;
    @Nullable
    public final String params;
}
