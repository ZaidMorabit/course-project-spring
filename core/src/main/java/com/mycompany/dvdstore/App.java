package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.FileMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.service.DefaultMovieService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MovieController movieController = new MovieController();
        DefaultMovieService movieService = new DefaultMovieService();
        MovieRepositoryInterface movieRepository = new FileMovieRepository();

        movieController.setMovieService(movieService);
        movieService.setMovieRepository(movieRepository);

        movieController.addUsingConsole();

    }
}
