package me.knighthat.innertube.request.body;

import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Value
public class PlayerBody implements RequestBody {

    @NotNull
    Context context;

    @NotNull
    String videoId;

    @Nullable
    String params;

    @Nullable
    Boolean racyCheckOk;

    @Nullable
    Boolean contentCheckOk;

    /**
     * Although optional, adding this reduces chances of
     * blocking significantly, especially on mobile devices.
     * <p>
     * A 12-character string is all required.
     */
    @Nullable
    ServiceIntegrityDimensions serviceIntegrityDimensions;

    @Value
    public static class ServiceIntegrityDimensions {

        @NotNull
        String poToken;
    }
}
