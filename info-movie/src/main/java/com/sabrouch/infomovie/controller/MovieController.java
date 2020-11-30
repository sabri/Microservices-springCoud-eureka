package com.sabrouch.infomovie.controller;



import com.sabrouch.infomovie.model.Movie;
import com.sabrouch.infomovie.model.MovieSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/info")

public class MovieController {
    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{movieId}")
    public Movie getinfomovie(@PathVariable("movieId") String movieId){

        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        return
                new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }

}
