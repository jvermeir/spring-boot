package com.example.rest.web.controller;

import com.example.rest.RestApplication;
import com.example.rest.service.MyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RestApplication.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class MyControllerTest {

    MockMvc mockMvc;
    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
         mockMvc = MockMvcBuilders
                .standaloneSetup(new MyController(new MyServiceImpl()))
                .build();
    }

    @Test
    public void givenTestDataIsLoaded_whenRetrievingAllData_then2ResultsAreReturned()
            throws Exception {
        // When
        ResultActions result  = this.mockMvc.perform(get("/stuff/all").contentType(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":\"id2\",\"description\":\"id2Value\",\"hash\":90972438},{\"id\":\"id1\",\"description\":\"id1Value\",\"hash\":-66739432}]"));
    }

}
