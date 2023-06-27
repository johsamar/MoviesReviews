package com.johsam.movies_reviews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAPI {

    @JsonProperty("message")
    private String message;

    @JsonProperty("response")
    private Object response;

    public ResponseAPI(String message, Object response) {
        this.message = message;
        this.response = response;
    }
    
}
