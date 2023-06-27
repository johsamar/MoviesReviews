package com.johsam.movies_reviews.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.johsam.movies_reviews.models.Movie;
import com.johsam.movies_reviews.repositories.MoviesRepository;
import com.johsam.movies_reviews.services.interfaces.MoviesService;

@Service
public class MoviesServiceImplement implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public Movie create(Movie movie) throws Exception {
        Movie movieCreated = moviesRepository.save(movie);
        if (movieCreated == null) {
            throw new Exception("Movie not created");
        }
        return movieCreated;
    }

    @Override
    public Movie getById(String id) throws Exception {
        Movie movie = moviesRepository.findById(id).orElse(null);

        if (movie == null) {
            throw new Exception("Movie not found");
        }

        return movie;
    }

    @Override
    public List<Movie> getAll() throws Exception {
        List<Movie> movies = moviesRepository.findAll();

        if (movies == null) {
            throw new Exception("Movies not found");
        }

        return movies;
    }

    @Override
    public Movie deleteById(String id) throws Exception {
        Movie movie = this.getById(id);

        moviesRepository.delete(movie);

        return movie;
    }

    @Override
    public Movie updateById(String id, Movie updateMovie) {

        return null;
    }

    @Override
    public Movie update(Movie updateMovie) throws Exception {
        Movie movie;
        if (updateMovie.get_id() != null) {
            movie = moviesRepository.save(updateMovie);
            if (movie == null) {
                throw new Exception("Movie not found");
            }
            return movie;
        }
        throw new Exception("The movie doesn't exist");
    }
}
