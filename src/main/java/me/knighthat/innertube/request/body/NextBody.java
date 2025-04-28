package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class NextBody implements RequestBody {

    @NotNull
    public final Context context;
    @NotNull
    public final String videoId;
    @NotNull
    public final String playlistId;
    @Nullable
    public final String params;
}
