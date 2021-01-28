package com.mycompany.dvdstore.web.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {

    @NotBlank
    @Size(max = 20)
    private String title;
    @NotBlank
    private String genre;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}