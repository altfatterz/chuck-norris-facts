package com.altfatterz.server;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface ChuckNorrisFactRepository extends Repository<ChuckNorrisFact, Long> {

    @Query("select cnf from ChuckNorrisFact cnf order by RAND()")
    List<ChuckNorrisFact> getOneRandomly(Pageable pageable);
}
