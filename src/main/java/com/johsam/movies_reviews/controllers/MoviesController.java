package com.johsam.movies_reviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johsam.movies_reviews.dto.ResponseAPI;
import com.johsam.movies_reviews.models.Movie;
import com.johsam.movies_reviews.services.MoviesServiceImplement;
import com.johsam.movies_reviews.utils.Constants;

@RestController
@RequestMapping(Constants.MOVIES)
public class MoviesController {

    @Autowired
    private MoviesServiceImplement moviesService;

    @GetMapping(Constants.GET_ALL)
    public ResponseEntity<ResponseAPI> getAll() {
        ResponseAPI response;

        try {
            List<Movie> allMovies = moviesService.getAll();
            response = new ResponseAPI(Constants.SUCCESS, allMovies);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response = new ResponseAPI(Constants.NOT_FOUND, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(Constants.CREATE)
    public ResponseEntity<ResponseAPI> create(@RequestBody Movie movie) {
        ResponseAPI response;

        try {
            Movie movieCreated = moviesService.create(movie);
            response = new ResponseAPI(Constants.CREATED, movieCreated);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response = new ResponseAPI(Constants.NOT_CREATED, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

    @GetMapping(Constants.GET_BY_ID)
    public ResponseEntity<ResponseAPI> findById(@PathVariable("id") String id) {
        ResponseAPI response;

        try {
            Movie movie = moviesService.getById(id);
            response = new ResponseAPI(Constants.SUCCESS, movie);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response = new ResponseAPI(Constants.NOT_FOUND, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @PutMapping(Constants.UPDATE)
    public ResponseEntity<ResponseAPI> findById(@RequestBody Movie movie) {
        ResponseAPI response;

        try {
            Movie movieUpdated = moviesService.update(movie);
            response = new ResponseAPI(Constants.UPDATED, movieUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response = new ResponseAPI(Constants.NOT_UPDATED, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

    @DeleteMapping(Constants.DELETE_BY_ID)
    public ResponseEntity<ResponseAPI> deleteById(@PathVariable("id") String id) {
        ResponseAPI response;

        try {
            Movie movie = moviesService.deleteById(id);
            response = new ResponseAPI(Constants.DELETED, movie);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response = new ResponseAPI(Constants.NOT_DELETED, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }
}
