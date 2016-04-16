package com.altfatterz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ChuckNorrisFactController.class)
public class CheckNorrisFactControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChuckNorrisFactService chuckNorrisFactService;

    @Test
    public void getOneRandomly() throws Exception {
        given(chuckNorrisFactService.getOneRandomly()).willReturn(new ChuckNorrisFact("Chuck Norris counted to infinity twice."));

        mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'fact':'Chuck Norris counted to infinity twice.'}"));
    }
}
