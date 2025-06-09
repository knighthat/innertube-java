package me.knighthat.innertube.response;

import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

// Ripped from NewPipeExtractor
@Value
public class Response {
    int    responseCode;
    String responseMessage;
    @NotNull
    Map<String, List<String>> responseHeaders;
    String responseBody;
}
