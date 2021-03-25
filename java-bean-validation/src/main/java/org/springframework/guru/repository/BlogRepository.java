package org.springframework.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.guru.model.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog,Long> {
}
