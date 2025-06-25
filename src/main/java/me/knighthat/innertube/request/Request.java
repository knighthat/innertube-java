package me.knighthat.innertube.request;

import lombok.Builder;
import lombok.Value;
import me.knighthat.innertube.request.body.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Map;

// Ripped from NewPipeExtractor
@Value
@Builder(builderClassName = "Builder")
public class Request {

    @NotNull
    String                    httpMethod;
    @NotNull
    String                    url;
    @NotNull
    @Unmodifiable
    Map<String, List<String>> headers;
    @Nullable       // Should only be null when [httpMethod] is "GET"
    RequestBody               dataToSend;
}
