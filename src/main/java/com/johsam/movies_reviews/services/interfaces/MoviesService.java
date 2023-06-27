package com.johsam.movies_reviews.services.interfaces;

import java.util.List;

import com.johsam.movies_reviews.models.Movie;

public interface MoviesService {

    Movie create(Movie movie) throws Exception;

    Movie getById(String id) throws Exception;

    List<Movie> getAll() throws Exception;

    Movie deleteById(String id) throws Exception;

    Movie updateById(String id, Movie movie);

    Movie update(Movie movie) throws Exception;
}
