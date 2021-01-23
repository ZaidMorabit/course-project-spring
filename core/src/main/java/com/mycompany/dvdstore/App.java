package com.mycompany.dvdstore;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "donnez le titre du film a ajouter: " );
        String title = sc.nextLine();
        System.out.println("donnez le genre du film");
        String genre = sc.nextLine();
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        MovieRepository movieRepository = new MovieRepository();

        movieRepository.add(movie);

    }
}
