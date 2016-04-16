package com.altfatterz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ChuckNorrisFactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChuckNorrisFactController.class);

    private ChuckNorrisFactService service;

    public ChuckNorrisFactController(ChuckNorrisFactService service) {
        LOGGER.debug("chuck norris controller initialised");
        this.service = service;
    }

    @GetMapping("/")
    public ChuckNorrisFact getOneRandomly() {
        ChuckNorrisFact chuckNorrisFact = service.getOneRandomly();
        LOGGER.debug("'{}'", chuckNorrisFact.getText());
        return chuckNorrisFact;
    }

}