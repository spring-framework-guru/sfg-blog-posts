package org.springframework.guru.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 2, message = "Blog Title must have atleast 2 characters")
    private String blogTitle;

    @NotBlank(message = "Blog Editor cannot be blank")
    private String blogEditor;

    @Email(message = "Email should be valid")
    private String blogEmail;

    public Blog() {
    }

    public Blog(long id, @NotNull(message = "Blog Title must have atleast 2 characters") String blogTitle, @NotBlank(message = "Blog Editor cannot be blank") String blogEditor, @Email(message = "Email should be valid") String blogEmail) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogEditor = blogEditor;
        this.blogEmail = blogEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogEditor() {
        return blogEditor;
    }

    public void setBlogEditor(String blogEditor) {
        this.blogEditor = blogEditor;
    }

    public String getBlogEmail() {
        return blogEmail;
    }

    public void setBlogEmail(String blogEmail) {
        this.blogEmail = blogEmail;
    }
}