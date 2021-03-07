package org.springframework.guru.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long blogId;
    private String blogTitle;

    public long getBlogId() {
        return blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
}
