package com.altfatterz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest // configures an in-memory database, scans for @Entity classes, @Component classes are not loaded into ApplicationContext.
public class ChuckNorrisFactRepositoryTests {

    @Autowired
    private TestEntityManager entityManager; // alternative to JPA EntityManager designed for tests

    @Autowired
    private ChuckNorrisFactRepository repository;

    @Test
    public void getOneRandomly() {
        String fact = "If at first you don't succeed, you're not Chuck Norris.";
        entityManager.persist(new ChuckNorrisFact(fact));

        List<ChuckNorrisFact> facts = repository.getOneRandomly(new PageRequest(0, 10));
        assertThat(facts.get(0).getText(), is(fact));
    }
}
