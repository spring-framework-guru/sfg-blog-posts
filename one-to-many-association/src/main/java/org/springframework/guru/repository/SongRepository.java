package org.springframework.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.guru.domain.Songs;

public interface SongRepository extends CrudRepository<Songs, Long> {

}
