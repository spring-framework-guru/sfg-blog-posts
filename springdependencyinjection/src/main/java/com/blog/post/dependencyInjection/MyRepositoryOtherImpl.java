package com.blog.post.dependencyInjection;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepositoryOtherImpl implements MyRepository {
    @Override
    public void saveInDB() {
        System.out.println("Save in another db");
    }
}
