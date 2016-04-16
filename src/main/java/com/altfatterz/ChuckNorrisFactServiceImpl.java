package com.altfatterz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ChuckNorrisFactServiceImpl implements ChuckNorrisFactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChuckNorrisFactServiceImpl.class);
    private static final String DEFAULT = "Chuck Norris has never won an Academy Award for acting... because he's not acting.";

    private ChuckNorrisFactRepository repository;

    public ChuckNorrisFactServiceImpl(ChuckNorrisFactRepository repository) {
        LOGGER.debug("chuck norris service initialised");
        this.repository = repository;
    }

    @Override
    public ChuckNorrisFact getOneRandomly() {
        List<ChuckNorrisFact> facts = repository.getOneRandomly(new PageRequest(0, 10));
        return !facts.isEmpty() ? facts.get(0) : new ChuckNorrisFact(DEFAULT);
    }
}

