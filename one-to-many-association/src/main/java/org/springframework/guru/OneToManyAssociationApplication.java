package org.springframework.guru;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.guru.domain.Movie;
import org.springframework.guru.domain.Songs;
import org.springframework.guru.repository.MovieRepository;
import org.springframework.guru.repository.SongRepository;

@SpringBootApplication
public class OneToManyAssociationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToManyAssociationApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(MovieRepository movieRepository,
                                         SongRepository songRepository) {
        return args -> {

            // create a new Movie
            Movie movie = new Movie("StarWars", "Arthur", "10SW");

            // save the movie
            movieRepository.save(movie);

            // create and save new songs
            songRepository.save(new Songs("OnMyWay", "Alan", movie));
            songRepository.save(new Songs("Sing me to sleep", "Alan Walker", movie));
            songRepository.save(new Songs("Faded", "Walker", movie));
        };
    }
}


