package com.project.vetfacade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient localApiClient() {
        return WebClient.create("http://localhost:8080/");
    }
}
