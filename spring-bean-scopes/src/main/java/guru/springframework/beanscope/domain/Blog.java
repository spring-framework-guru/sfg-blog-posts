package guru.springframework.beanscope.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Blog {
    private int id;
    private String title;


    @Autowired
    private Author author;

    public Blog() {
    }

    public Blog(int id, String title) {
        this.id = id;
        this.title = title;
    }

    /*Getter and setter for fields*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
