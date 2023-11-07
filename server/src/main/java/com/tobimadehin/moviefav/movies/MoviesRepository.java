package com.tobimadehin.moviefav.movies;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviesRepository extends CrudRepository<Movies, Long> {
    List<Movies> findByTitleContaining(String title);
}
