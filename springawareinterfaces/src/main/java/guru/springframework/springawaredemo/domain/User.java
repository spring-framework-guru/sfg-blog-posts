package guru.springframework.springawaredemo.domain;

import org.springframework.stereotype.Component;

public class User {
    private int userId;
    private String name;

    public User() {
    }


    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
