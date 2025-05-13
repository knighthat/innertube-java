package me.knighthat.innertube.request.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class PlayerBody implements RequestBody {

    @NotNull
    private final Context context;

    @NotNull
    private final String videoId;

    @Nullable
    private final String params;

    @Nullable
    private final Boolean racyCheckOk;

    @Nullable
    private final Boolean contentCheckOk;

    /**
     * Although optional, adding this reduces chances of
     * blocking significantly, especially on mobile devices.
     * <p>
     * A 12-character string is all required.
     */
    @Nullable
    private final ServiceIntegrityDimensions serviceIntegrityDimensions;

    @Data
    public static class ServiceIntegrityDimensions {

        @NotNull
        private final String poToken;
    }
}
