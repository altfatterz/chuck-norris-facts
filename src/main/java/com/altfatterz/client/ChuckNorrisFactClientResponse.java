package com.altfatterz.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Zoltan Altfatter
 */
public class ChuckNorrisFactClientResponse {

    private String fact;

    public ChuckNorrisFactClientResponse(@JsonProperty("fact") String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }
}
