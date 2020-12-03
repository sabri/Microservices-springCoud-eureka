package com.sabrouch.catalogmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableConfigurationProperties
// enable hystrix for circuit breaker pattern . to handle failing api by break api for a while
//@EnableCircuitBreaker
//@EnableHystrixDashboard

// for eureka server
@EnableEurekaClient
public class CatalogMovieApplication {
    @LoadBalanced
    //loadbalancer is helpful when we have multiple instance with the some api
    // this bean to autowired this rest template any where in your appp
    @Bean
    public RestTemplate getRestTemplate() {
        //set timeout for request for avoiding thread get blocked in tomcat server
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(3000);
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    //webclient is like rest template but is complicated
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogMovieApplication.class, args);
    }

}
