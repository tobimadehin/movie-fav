package com.tobimadehin.moviefav.movies;

public class MoviesController {
    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }
}
