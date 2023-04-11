package org.example.movies.service;

import org.example.movies.data.MovieRepository;
import org.example.movies.model.Genre;
import org.example.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int duration) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String movie_name) {
        return movieRepository.findByName(movie_name.toLowerCase());
    }

    public Collection<Movie> findByName_Whit_Lambda(String movie_name){
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(movie_name.toLowerCase())).collect(Collectors.toList());
    }
}
