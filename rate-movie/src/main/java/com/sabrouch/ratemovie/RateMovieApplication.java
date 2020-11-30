package com.sabrouch.ratemovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RateMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateMovieApplication.class, args);
    }

}
