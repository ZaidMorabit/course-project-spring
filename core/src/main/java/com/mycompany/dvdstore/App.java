package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//definit une classe de configuration spring
//@Configuration
//si on ne specifie pas de basepackages on scanne le package de cette classe
//@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller","com.mycompany.dvdstore.service","com.mycompany.dvdstore.repository.file"})
//specifie le fichier property
//si le fichier s'appelle application.properties dans le dossier ressources pas besoin de cette annotation (convention)
//@PropertySource("classpath:application.properties")
//@ImportResource("classpath:applicationContext.xml") //specifie un xml complementaire au cas ou on veut definir des info dans le fichier xml
public class App
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(App.class); //instancie la/les classe/s
        ApplicationContext context = SpringApplication.run(App.class,args);

        MovieController movieController = context.getBean(MovieController.class);

        movieController.addUsingConsole();

    }
}
