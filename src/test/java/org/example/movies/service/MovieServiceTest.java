package org.example.movies.service;

import org.example.movies.data.MovieRepository;
import org.example.movies.model.Movie;
import org.example.movies.model.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MovieServiceTest {

    private MovieService movieService;

    @Before
    public void setup() {
        String name_director = "Desconocido";
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Guillermo"),
                new Movie(2, "Memento", 113, Genre.THRILLER, name_director),
                new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, name_director),
                new Movie(4, "Super 8", 112, Genre.THRILLER, name_director),
                new Movie(5, "Scream", 111, Genre.HORROR, "Guillermo"),
                new Movie(6, "Home Alone", 103, Genre.COMEDY, "Jorge Lucas"),
                new Movie(7, "Matrix", 136, Genre.ACTION, "Jorge Lucas"),
                new Movie(8, "Dark Phoenix", 190, Genre.COMEDY, "Tobias Pacheco"),
                new Movie(9, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos")
        ));
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMoviesId(movies), is(Arrays.asList(3, 6, 8)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMoviesId(movies), is(Arrays.asList(2, 3, 4, 5, 6, 9)));

    }

    @Test
    public void return_movies_by_name() {
        Collection<Movie> movies = movieService.findMoviesByName("Dark");
        //assertTrue(movies.size()>0);
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Guillermo"))
        ));
    }

    @Test
    public void return_movies_by_name_whit_lambda() {
        Collection<Movie> movies = movieService.findByName_Whit_Lambda("Dark");
        //assertTrue(movies.size()>0);
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Guillermo"),
                new Movie(8, "Dark Phoenix", 190, Genre.COMEDY, "Tobias Pacheco"),
                new Movie(9, "Dark Moon", 100, Genre.THRILLER, "Camilo Cubillos"))
        ));
    }

    private List<Integer> getMoviesId(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Nested
    @DisplayName("when searching movies by multiple attributes")
    class SearchByTemplateMethod {

        @Test
        @DisplayName("using id")
        void whenUsingId() {
            Collection<Movie> movies = movieService.findByMovieTemplate(new Movie(5, null, null, Genre.ACTION, null));
            assertEquals(Collections.singletonList(5), getMoviesId(movies));
        }

        @Test
        @DisplayName("using negative minutes")
        void whenUsingNegativeMinutes() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> movieService.findByMovieTemplate(new Movie(null, null, -15, Genre.ACTION, null))
            );
        }

        @Test
        @DisplayName("using genre and minutes")
        void whenUsingGenreAndMinutes() {
            Collection<Movie> movies = movieService.findByMovieTemplate(new Movie(null, null, 180, Genre.ACTION, null));
            assertEquals(Arrays.asList(1, 5), getMoviesId(movies));
        }

        @Test
        @DisplayName("using name and minutes")
        void whenUsingNameAndMinutes() {
            Collection<Movie> movies = movieService.findByMovieTemplate(new Movie(null, "annabelle", 100, null, null));
            assertEquals(Collections.singletonList(7), getMoviesId(movies));
        }

        @Test
        @DisplayName("using director and minutes")
        void whenUsingDirectorAndMinutes() {
            Collection<Movie> movies = movieService.findByMovieTemplate(new Movie(null, null, 110, null, "Chris"));
            assertEquals(Collections.singletonList(4), getMoviesId(movies));
        }
    }
    // fin nested
}