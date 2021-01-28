package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller //aucune difference entre @Component et @Controller dans le traitement par spring mais a plus de sens à la lecture
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieServiceInterface movieService;

    @PostMapping
    //@ModelAttribute recupere l'objet créé par spring et mappé avec le formulaire reçu
    //@Valid active la validation du bean
    //binding result est à placer apres le dernier bean ModelAttibute
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        movieService.registerMovie(movie);
        return "movie-added";
    }

    @GetMapping
    public String displayHome(Model model){
        model.addAttribute("movies",movieService.getMovieList());
        return "movie-list"; //retourne le nom de la page dans templates sans l'extention
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id")long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie-details";
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }
}
