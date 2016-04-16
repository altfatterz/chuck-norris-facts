package com.altfatterz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ChuckNorrisFactJsonTests {

    private JacksonTester<ChuckNorrisFact> json;

    @Test
    public void serialize() throws IOException {
        ChuckNorrisFact fact = new ChuckNorrisFact("When Chuck Norris turned 18, his parents moved out.");

        JsonContent<ChuckNorrisFact> write = this.json.write(fact);
        System.out.println(write.getJson());

        assertThat(this.json.write(fact)).isEqualToJson("expected.json");
    }

    @Test
    public void deserialize() throws IOException {
        String content = "{\"fact\":\"Chuck Norris knows Victoria's secret.\"}";

        assertThat(this.json.parse(content)).isEqualTo(new ChuckNorrisFact("Chuck Norris knows Victoria's secret."));

    }
}
