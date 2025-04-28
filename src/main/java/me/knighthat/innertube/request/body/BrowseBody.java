package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class BrowseBody implements RequestBody {

    @NotNull
    public final Context context;
    @NotNull
    public final String browseId;
    @NotNull
    public final String playlistId;
    @Nullable
    public final String params;
}
