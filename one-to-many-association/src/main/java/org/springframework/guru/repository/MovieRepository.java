package org.springframework.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.guru.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie,Long> {
//    Movie findByMovieId(Long id);
}
