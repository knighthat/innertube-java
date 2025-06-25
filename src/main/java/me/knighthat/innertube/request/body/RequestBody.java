package me.knighthat.innertube.request.body;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

public interface RequestBody {

// START: Static fields/functions
    @NotNull Gson GSON = new Gson();
// END: Static fields/functions

    @NotNull Context getContext();

    default @NotNull String toJsonString() {
        return GSON.toJson( this );
    }
}
