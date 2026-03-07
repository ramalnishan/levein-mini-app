package com.bytelabs.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {
    @Bean
    public RestClient serviceClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8081/api")
                .build();
    }
}
