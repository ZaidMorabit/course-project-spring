package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;

import java.util.Scanner;

public class MovieController {

    MovieServiceInterface movieService;

    public void addUsingConsole(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "donnez le titre du film a ajouter: " );
        String title = sc.nextLine();
        System.out.println("donnez le genre du film");
        String genre = sc.nextLine();
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);

        movieService.registerMovie(movie);
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }
}