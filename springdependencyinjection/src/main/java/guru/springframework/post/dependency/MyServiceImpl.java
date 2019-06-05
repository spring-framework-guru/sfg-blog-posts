package guru.springframework.post.dependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    private MyRepository myRepository;

    public void storeInDb(){
        myRepository.saveInDB();
    }
    @Autowired(required = false)
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
