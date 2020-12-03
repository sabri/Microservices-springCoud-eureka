package com.sabrouch.catalogmovie.ressource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by sabrouch.
 * Date: 12/3/2020
 */
@Service
public class UserRatingInfo {

    private final RestTemplate restTemplate;

    public UserRatingInfo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //@CircuitBreaker(fallbackMethod="getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        return restTemplate.getForObject("http://RATE-MOVIE/rate/users/" + userId, UserRating.class);
    }

    public UserRating  getFallbackUserRating(@PathVariable("userId") String userId){
        return new UserRating("", Arrays.asList(new Rating("",0 )));
    }
}
