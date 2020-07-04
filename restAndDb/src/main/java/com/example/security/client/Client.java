package com.example.security.client;

import com.example.security.model.Stuff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Client {
    @Autowired
    RestTemplate restTemplate;

    static Logger logger = LoggerFactory.getLogger(Client.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        List<Stuff> stuff = restTemplate.getForObject(
                "http://localhost:9090/stuff/all", List.class);
        logger.info(stuff.toString());
    }

}
