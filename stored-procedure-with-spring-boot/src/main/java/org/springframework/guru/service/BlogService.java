package org.springframework.guru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.guru.model.Blog;
import org.springframework.guru.repository.BlogRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<Blog> getTotalBlogs(){
        return em.createNamedStoredProcedureQuery("getAllBlogs").getResultList();
    }
    public List<Blog> getBlogsByTitle(String title) {
        return em.createNamedStoredProcedureQuery("getBlogsByTitle").setParameter("tblogTitle",title).getResultList();
    }

}