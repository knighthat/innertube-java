package me.knighthat.innertube.request.body;

import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
public class NextBody implements RequestBody {

    @NotNull
    Context context;
    @NotNull
    String  videoId;
    @NotNull
    String  playlistId;
    @Nullable
    String  params;
}
