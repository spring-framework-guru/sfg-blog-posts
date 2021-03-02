package org.springframework.guru.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.guru.model.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
