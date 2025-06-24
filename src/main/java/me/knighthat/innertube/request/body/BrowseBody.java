package me.knighthat.innertube.request.body;

import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
public class BrowseBody implements RequestBody {

    @NotNull
    Context context;
    @Nullable
    String  browseId;
    @Nullable
    String  playlistId;
    @Nullable
    String  params;
    @Nullable
    String continuation;
}
