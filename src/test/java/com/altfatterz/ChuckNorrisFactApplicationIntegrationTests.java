package com.altfatterz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/init-for-full-integration-test.sql")
public class ChuckNorrisFactApplicationIntegrationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void random() {
		ResponseEntity<String> fact = template.getForEntity("/", String.class); // cannot use ChuckNorrisFact deserialization

		assertThat(fact.getBody(), containsString("Chuck Norris sleeps with a pillow under his gun."));
	}
}
