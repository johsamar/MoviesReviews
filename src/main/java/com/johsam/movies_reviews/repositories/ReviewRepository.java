package com.johsam.movies_reviews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.johsam.movies_reviews.models.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String>{
    
}
