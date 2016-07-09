package com.altfatterz.client;

import com.altfatterz.client.ChuckNorrisFactClient;
import com.altfatterz.client.ChuckNorrisFactClientResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Zoltan Altfatter
 */
@RunWith(SpringRunner.class)
@RestClientTest({ChuckNorrisFactClient.class, ChuckNorrisFactClientProperties.class})
public class ChuckNorrisFactClientTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private ChuckNorrisFactClient client;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void getRandomChuckNorrisFactWhenResultIsSuccessShouldReturnFact() {
        server.expect(requestTo("/")).andRespond(withSuccess(getClassPathResource("chucknorrisfact.json"), MediaType.APPLICATION_JSON));
        ChuckNorrisFactClientResponse response = client.getRandomChuckNorrisFact();
        assertThat(response.getFact()).isEqualTo("There is no theory of evolution. Just a list of animals Chuck Norris allows to live.");
    }

    @Test
    public void getRandomChuckNorrisFactWhenResultIsErrorShouldThrowException() {
        server.expect(requestTo("/")).andRespond(withServerError());
        this.thrown.expect(HttpServerErrorException.class);
        client.getRandomChuckNorrisFact();
    }

    private ClassPathResource getClassPathResource(String path) {
        return new ClassPathResource(path, getClass());
    }
}
