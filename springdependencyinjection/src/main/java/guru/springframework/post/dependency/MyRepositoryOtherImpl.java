package guru.springframework.post.dependency;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepositoryOtherImpl implements MyRepository {
    @Override
    public void saveInDB() {
        System.out.println("Save in another db");
    }
}
