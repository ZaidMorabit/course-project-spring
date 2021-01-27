package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    @Autowired //ne passe plus par le setter sauf si elle est sur le setter (bytype)
    MovieRepositoryInterface movieRepository;

    public void registerMovie(Movie movie){
        movieRepository.add(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.list();
    }

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }
}
