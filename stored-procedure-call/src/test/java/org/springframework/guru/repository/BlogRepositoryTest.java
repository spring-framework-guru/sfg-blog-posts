package org.springframework.guru.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.guru.domain.Blog;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogRepositoryTest {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    private EntityManager entityManager;
    @Test
    public void GET_TOTAL_BLOGS_BY_TITLETest(){
        int number= blogRepository.GET_TOTAL_BLOGS_BY_TITLE("Blog 1");
        assertEquals(3,number);
    }

    @Test
    public void getTotalBlogsByTitleTest(){
        int number= blogRepository.getTotalBlogsByTitle("Blog 1");
        assertEquals(3, number);
    }

    @Test
    public void getTotalBlogsByTitleProcedureNameTst(){
        int number= blogRepository.getTotalBlogsByTitleProcedureName("Blog 1");
        assertEquals(3, number);
    }

    @Test
    public void getTotalBlogsByTitleValueTest(){
        int number= blogRepository.getTotalBlogsByTitleValue("Blog 1");
        assertEquals(3, number);
    }

    @Test
    public void namedStoredProcedureQueryTest(){
           List<Blog> blogs = entityManager.createNamedStoredProcedureQuery("get_blog_details")
                .setParameter("title", "Blog 1").getResultList();
        assertEquals(3, blogs.size());
    }

}