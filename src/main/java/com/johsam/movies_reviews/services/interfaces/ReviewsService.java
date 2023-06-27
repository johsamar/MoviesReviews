package com.johsam.movies_reviews.services.interfaces;

import java.util.List;

import com.johsam.movies_reviews.models.Review;

public interface ReviewsService {

    Review create(Review review) throws Exception;

    Review getById(String id) throws Exception;

    List<Review> getAll() throws Exception;

    Review deleteById(String id) throws Exception;

    Review updateById(String id, Review review);

    Review update(Review review) throws Exception;

}
