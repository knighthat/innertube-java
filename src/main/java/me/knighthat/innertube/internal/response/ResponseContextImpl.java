package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.ResponseContext;

import java.util.List;

@Value
class ResponseContextImpl implements ResponseContext {

    String                         visitorData;
    List<ServiceTrackingParamImpl> serviceTrackingParams;
    Integer                        maxAgeSeconds;

    @Value
    static class ServiceTrackingParamImpl implements ServiceTrackingParam {

        String          service;
        List<ParamImpl> params;

        @Value
        static class ParamImpl implements Param {

            String key;
            String value;
        }
    }
}