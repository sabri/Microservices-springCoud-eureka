package com.sabrouch.catalogmovie.ressource;



import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

    private final DiscoveryClient discoveryClient;
    private final MovieInfo movieInfo;
     private final UserRatingInfo userRatingInfo;

    public MovieCatalog(DiscoveryClient discoveryClient, MovieInfo movieInfo, UserRatingInfo userRatingInfo) {
        this.discoveryClient = discoveryClient;
        this.movieInfo = movieInfo;
        this.userRatingInfo = userRatingInfo;
    }


    @RequestMapping("/{userId}")
    //@CircuitBreaker(fallbackMethod="getFallbackCatalog")
    public List<CatlogMovie> getCatalog(@PathVariable("userId") String userId) {
        //get all movie

/*
        List<Rating> rating = Arrays.asList(
                new Rating("123", 4),
                new Rating("13", 3),
                new Rating("1234", 5)

        );
        */
//singletonList return immutable List serializable
        //call api  and userrating is model recive list of objects
        UserRating ratings = userRatingInfo.getUserRating(userId);

        return ratings.getUserRating()
                .stream()
                .map( rating ->  movieInfo.getCatlogMovie(rating))
                .collect(Collectors.toList());
    }




/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/


}
