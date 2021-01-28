package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private MovieServiceInterface movieService;

    public HomeController() {
    }

    @Autowired
    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("add-movie-form") //si la value du get mapping a le meme nom que la page a afficher, pas de return du nom de la page
    public void displayMovieForm(@ModelAttribute MovieForm movie){ //l'objet peut preremplir le form si il existe

    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }


}
