package me.knighthat.impl.response;

import lombok.Data;
import me.knighthat.innertube.response.ResponseContext;

@Data
public class ResponseContextImpl implements ResponseContext {

    private final String visitorData;
    private final Integer maxAgeSeconds;
}