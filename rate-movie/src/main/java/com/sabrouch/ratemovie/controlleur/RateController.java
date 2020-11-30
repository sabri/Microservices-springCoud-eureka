package com.sabrouch.ratemovie.controlleur;


import com.sabrouch.ratemovie.model.Rating;
import com.sabrouch.ratemovie.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sabrouch.
 * Date: 11/13/2020
 */

@RestController
@RequestMapping("/rate")
public class RateController {
    @RequestMapping("/movies/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 100);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating (@PathVariable("userId") String userId){
       /* List<Rating> ratings= Arrays.asList(
                new Rating("123", 4),
                new Rating("13", 3),
                new Rating("1234", 5)

        );

        */
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
