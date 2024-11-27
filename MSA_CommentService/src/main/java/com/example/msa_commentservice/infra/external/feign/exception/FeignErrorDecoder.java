package com.example.msa_commentservice.infra.external.feign.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return new Exception(response.reason());
    }
}
