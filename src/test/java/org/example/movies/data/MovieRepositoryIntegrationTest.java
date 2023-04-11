package org.example.movies.data;

import org.example.movies.data.MovieRepository;
import org.example.movies.model.Genre;
import org.example.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {

    private DataSource dataSource;
    private MovieRepositoryImpl movieRepository;

    private String name_director;

    @Before
    public void setup()throws SQLException{
        name_director = "Desconocido";
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL",
                "Maverick", "milo");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryImpl(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException{
        Collection<Movie> movies = movieRepository.findAll();
        assertThat( movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Guillermo"),
                new Movie(2, "Memento", 113, Genre.THRILLER, name_director)
        )));
    }

    @Test
    public void load_movie_by_id(){
        Movie movieId = movieRepository.findById(2);
        assertThat(movieId, is(new Movie(2, "Memento", 113, Genre.THRILLER, name_director)));
    }

    @Test
    public void load_movie_by_name(){
        Collection<Movie> movies = movieRepository.findByName("dark");
        assertTrue(movies.size()>=1);
    }

    @Test
    public void insert_a_movie(){
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, name_director);
        movieRepository.saveOrUpdate(movie);
        Movie movieFrombDB = movieRepository.findById(3);
        assertTrue(movieFrombDB != null);
        assertThat(movieFrombDB, is(new Movie(3,"Super 8", 112, Genre.THRILLER, name_director)));
    }

    @After
    public void tearDown() throws Exception {
        //Remove H2 files
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}