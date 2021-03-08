package org.springframework.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.guru.domain.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Procedure
    int GET_TOTAL_BLOGS_BY_TITLE(String title);

    @Procedure("GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitle(String title);

    @Procedure(procedureName = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleProcedureName(String model);

    @Procedure(value = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleValue(String model);

    @Procedure(name = "Blog.getTotalBlogsByTitleEntiy")
    int getTotalBlogsByTitleEntiy(@Param("model_in") String model);



}
