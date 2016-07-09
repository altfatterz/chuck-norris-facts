package com.altfatterz.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Zoltan Altfatter
 */
@Component
@ConfigurationProperties
public class ChuckNorrisFactClientProperties {

    private String serviceRootUrl = "http://localhost:8080";

    public String getServiceRootUrl() {
        return serviceRootUrl;
    }

    public void setServiceRootUrl(String serviceRootUrl) {
        this.serviceRootUrl = serviceRootUrl;
    }
}
