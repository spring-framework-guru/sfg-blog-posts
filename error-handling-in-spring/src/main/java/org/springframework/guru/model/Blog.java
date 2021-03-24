package org.springframework.guru.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private int blogId;
    private String blogTitle;
    private String blogCreator;
    private int yearOfPost;

    public Blog() {
    }

    public Blog(int blogId, String blogTitle, String blogCreator, int yearOfPost) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogCreator = blogCreator;
        this.yearOfPost = yearOfPost;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogCreator() {
        return blogCreator;
    }

    public void setBlogCreator(String blogCreator) {
        this.blogCreator = blogCreator;
    }

    public int getYearOfPost() {
        return yearOfPost;
    }

    public void setYearOfPost(int yearOfPost) {
        this.yearOfPost = yearOfPost;
    }
}
