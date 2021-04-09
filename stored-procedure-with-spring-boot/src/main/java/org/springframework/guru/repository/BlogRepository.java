package org.springframework.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.guru.model.Blog;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

}

