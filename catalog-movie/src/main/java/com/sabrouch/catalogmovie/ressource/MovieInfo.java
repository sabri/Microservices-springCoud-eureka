package com.sabrouch.catalogmovie.ressource;

/**
 * Created by sabrouch.
 * Date: 12/3/2020
 */

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    private final RestTemplate restTemplate;

    public MovieInfo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //@CircuitBreaker(fallbackMethod="getFallbackCatalogMovie")

    public CatlogMovie getCatlogMovie(Rating rating){

        Movie movie = restTemplate.getForObject("http://INFO-MOVIE/info/" +rating.getMovieId(), Movie.class);

        return new CatlogMovie(movie.getName(), "desc", rating.getRating());


    }

}
