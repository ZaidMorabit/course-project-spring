package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie save(Movie movie) {
        KeyHolder kh=new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt=connection.prepareStatement("INSERT INTO MOVIE (TITLE,GENRE,DESCRIPTION) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,movie.getTitle());
            pstmt.setString(2,movie.getGenre());
            pstmt.setString(3,movie.getDescription());
            return pstmt;
        },kh);
        movie.setId(kh.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query("SELECT ID,TITLE,GENRE FROM MOVIE",
                (rs, rownum) -> new Movie(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("GENRE")));
    }

    @Override
    public Optional<Movie> findById(Long id) {
        Movie movie = jdbcTemplate.queryForObject("SELECT * FROM MOVIE WHERE ID=?",
                new Object[]{id},
                (rs, rownum) -> new Movie(
                        rs.getLong("ID"),
                        rs.getString("TITLE"),
                        rs.getString("GENRE"),
                        rs.getString("DESCRIPTION")));
        return Optional.of(movie);
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Movie movie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

}
