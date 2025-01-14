package com.microservices.demo.currency_conversion_service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConversionConfig {

    @Bean
    @LoadBalanced // Enables Spring Cloud LoadBalancer with Eureka for RestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
