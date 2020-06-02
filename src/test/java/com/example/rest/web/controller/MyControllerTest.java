package com.example.rest.web.controller;

import com.example.rest.RestApplication;
import com.example.rest.model.Stuff;
import com.example.rest.repo.StuffRepository;
import com.example.rest.service.MyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RestApplication.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class MyControllerTest {

    @MockBean
    StuffRepository stuffRepository;

    MockMvc mockMvc;
    @BeforeEach
    public void before() {
        Stuff testid1Value = new Stuff(1, "Testid1Value");
        Stuff testid2Value = new Stuff(2, "Testid2Value");
        when(stuffRepository.getById(1)).thenReturn(testid1Value);
        when(stuffRepository.findAll()).thenReturn(Arrays.asList(testid1Value, testid2Value));
        MockitoAnnotations.initMocks(this);
         mockMvc = MockMvcBuilders
                .standaloneSetup(new MyController(new MyServiceImpl(stuffRepository)))
                .build();
    }

    @Test
    public void givenTestDataIsLoaded_whenRetrievingAllData_then2ResultsAreReturned()
            throws Exception {
        // When
        ResultActions result  = this.mockMvc.perform(get("/stuff/all").contentType(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"description\":\"Testid1Value\",\"hash\":-1156805585},{\"id\":2,\"description\":\"Testid2Value\",\"hash\":-1638710611}]"));
    }

}
