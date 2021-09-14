package com.br.octo.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //Instancia unica - Singleton do RestTemplate
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
