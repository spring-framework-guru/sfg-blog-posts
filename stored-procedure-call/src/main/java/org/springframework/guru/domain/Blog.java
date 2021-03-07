package org.springframework.guru.domain;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(name = "get_blog_details", procedureName = "get_blog_details", resultClasses = {
        Blog.class }, parameters = {
        @StoredProcedureParameter(name = "title", mode = ParameterMode.IN, type = String.class) })
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long blogId;

    @Column
    private String title;

    @Column
    private Integer yearOfPost;

    public Blog() {
    }

    public Blog(String title, Integer yearOfPost) {
        this.title = title;
        this.yearOfPost = yearOfPost;
    }

    public long getBlogId() {
        return blogId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearOfPost() {
        return yearOfPost;
    }
}
