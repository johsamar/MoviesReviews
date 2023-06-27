package com.johsam.movies_reviews.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johsam.movies_reviews.models.Review;
import com.johsam.movies_reviews.repositories.ReviewRepository;
import com.johsam.movies_reviews.services.interfaces.ReviewsService;

@Service
public class ReviewsServiceImplement implements ReviewsService{

    @Autowired
    ReviewRepository reviewRepository;

   @Override
    public Review create(Review review) throws Exception {
        Review movieCreated = reviewRepository.save(review);
        if (movieCreated == null) {
            throw new Exception("Review not created");
        }
        return movieCreated;
    }

    @Override
    public Review getById(String id) throws Exception {
        Review review = reviewRepository.findById(id).orElse(null);

        if (review == null) {
            throw new Exception("Review not found");
        }

        return review;
    }

    @Override
    public List<Review> getAll() throws Exception {
        List<Review> movies = reviewRepository.findAll();

        if (movies == null) {
            throw new Exception("Reviews not found");
        }

        return movies;
    }

    @Override
    public Review deleteById(String id) throws Exception {
        Review review = this.getById(id);

        reviewRepository.delete(review);

        return review;
    }

    @Override
    public Review updateById(String id, Review updateReview) {

        return null;
    }

    @Override
    public Review update(Review updateReview) throws Exception {
        Review review;
        if (updateReview.get_id() != null) {
            review = reviewRepository.save(updateReview);
            if (review == null) {
                throw new Exception("Review not found");
            }
            return review;
        }
        throw new Exception("The review doesn't exist");
    }
    
}
