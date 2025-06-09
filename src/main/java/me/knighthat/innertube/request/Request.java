package me.knighthat.innertube.request;

import lombok.Builder;
import lombok.Value;
import me.knighthat.innertube.request.body.RequestBody;

import java.util.List;
import java.util.Map;

// Ripped from NewPipeExtractor
@Value
@Builder(builderClassName = "Builder")
public class Request {
    String                    httpMethod;
    String                    url;
    Map<String, List<String>> headers;
    RequestBody               dataToSend;
}
