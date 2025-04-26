package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class NextBody {

    @NotNull
    public final Context.Client client;
    @NotNull
    public final String videoId;
    @Nullable
    public final String params;
    @Nullable
    public final String playlistId;
}
