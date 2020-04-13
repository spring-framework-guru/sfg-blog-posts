package guru.springframework.beanscope.domain;

public class Author {
    private int id;
    private String name;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /*Getter and setter methods*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
