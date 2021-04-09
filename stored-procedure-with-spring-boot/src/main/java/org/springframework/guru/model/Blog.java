package org.springframework.guru.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllBlogs",procedureName = "getAllBlogs"),
        @NamedStoredProcedureQuery(name = "getBlogsByTitle", procedureName = "getBlogsByTitle", parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "tblogTitle",type=String.class)} )})

public class Blog {
    @Id
    private Integer blogId;
    private String blogTitle;
    private Integer yearOfPost;

    public Blog() {
    }

    public Blog(Integer blogId, String blogTitle, Integer yearOfPost) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.yearOfPost = yearOfPost;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Integer getYearOfPost() {
        return yearOfPost;
    }

    public void setYearOfPost(Integer yearOfPost) {
        this.yearOfPost = yearOfPost;
    }
}