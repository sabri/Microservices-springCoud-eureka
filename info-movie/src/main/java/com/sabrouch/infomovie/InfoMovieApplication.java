package com.sabrouch.infomovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class InfoMovieApplication {
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

    public static void main(String[] args) {
        SpringApplication.run(InfoMovieApplication.class, args);
    }

}
