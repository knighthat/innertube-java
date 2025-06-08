package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Runs;

import java.util.List;

@Value
class RunsImpl implements Runs {

    List<RunImpl>     runs;
    AccessibilityImpl accessibility;

    @Value
    static class RunImpl implements Run {

        Boolean      bold;
        String       text;
        EndpointImpl navigationEndpoint;
    }
}