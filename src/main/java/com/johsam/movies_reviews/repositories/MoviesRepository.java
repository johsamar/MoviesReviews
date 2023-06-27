package com.johsam.movies_reviews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.johsam.movies_reviews.models.Movie;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String>{
    
}
