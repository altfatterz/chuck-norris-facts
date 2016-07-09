package com.altfatterz.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zoltan Altfatter
 */
@Service
public class ChuckNorrisFactClient {

    private final RestTemplate restTemplate;

    public ChuckNorrisFactClient(ChuckNorrisFactClientProperties properties, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri(properties.getServiceRootUrl()).build();
    }

    public ChuckNorrisFactClientResponse getRandomChuckNorrisFact() {
        return restTemplate.getForObject("/", ChuckNorrisFactClientResponse.class);
    }

}
