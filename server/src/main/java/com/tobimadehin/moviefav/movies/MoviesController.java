package com.tobimadehin.moviefav.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class MoviesController {
    @Autowired
    MoviesRepository moviesRepository;

    // Retrieve all movies
    @GetMapping("/movies")
    public ResponseEntity<String> getAllMovies(@RequestParam(required = false) String title) {
        try {
            List<Movies> movies = new ArrayList<Movies>();

            if (title == null)
                moviesRepository.findAll().forEach(movies::add);
            else
                moviesRepository.findByTitleContaining(title).forEach(movies::add);

            if (movies.isEmpty()) {
                return new ResponseEntity<>("No movies available!", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(movies.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Find movie by ID
    @GetMapping("/movies/{id}")
    public ResponseEntity<String> getMoviesById(@PathVariable("id") Long id) {
        Optional<Movies> movieData = moviesRepository.findById(id);

        try {
            if (movieData.isPresent()) {
                return new ResponseEntity<>(movieData.get().toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No matching movie found!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create movie
    @PostMapping("/movies")
    public ResponseEntity<String> createMovie(@RequestBody Movies movie) {
        try {
            Movies movieToSave = moviesRepository.save(movie);
            return new ResponseEntity<>(movieToSave.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update movie
    @PutMapping("/movies/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable("id") Long id, @RequestBody Movies movie) {
        try {
            Optional<Movies> movieData = moviesRepository.findById(id);

            if (movieData.isPresent()) {
                Movies movieToUpdate = movieData.get();
                movieToUpdate.setTitle(movie.getTitle());
                movieToUpdate.setThumbnail(movie.getThumbnail());
                movieToUpdate.setUser_id(movie.getUser_id());
                movieToUpdate.setDescription(movie.getDescription());
                movieToUpdate.setCategory(movie.getCategory());

                return new ResponseEntity<>(moviesRepository.save(movieToUpdate).toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No matching movie found!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete movie
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {
        try {
            Optional<Movies> movieData = moviesRepository.findById(id);

            if (movieData.isPresent()) {
                moviesRepository.deleteById(id);
            } else {
                return new ResponseEntity<>("No matching movie found!", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all movies
    @DeleteMapping("/movies")
    public ResponseEntity<String> deleteAllMovie() {
        try {
            List<Movies> movies = new ArrayList<Movies>();
            moviesRepository.findAll().forEach(movies::add);

            if (movies.isEmpty()) {
                return new ResponseEntity<>("No movies to delete!", HttpStatus.NOT_FOUND);
            } else {
                moviesRepository.deleteAll();
                return new ResponseEntity<>("All movies has been successfully deleted!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
