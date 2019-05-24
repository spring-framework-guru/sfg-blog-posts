package guru.springframework.post.dependency;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MyRepositoryImpl implements MyRepository {

    public void saveInDB(){
        System.out.println("Save in db");
    }
}
