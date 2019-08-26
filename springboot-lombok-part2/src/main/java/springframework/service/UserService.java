package springframework.service;

import guru.springframework.domain.constructor.ConstructorUserDemo;
import guru.springframework.domain.data.DataUserDemo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /*
        check @Data annotation
    */
    public void checkDataAnnotation() {
        System.out.println("**");
        DataUserDemo dataUserDemo = new DataUserDemo();
        dataUserDemo.setUserId(101);
        dataUserDemo.setUserName("John Doe");
        dataUserDemo.setUserId(25);
        System.out.println("Id: " + dataUserDemo.getUserId() + "Name: " + dataUserDemo.getUserName() + "Age: " + dataUserDemo.getUserAge());
        System.out.println("**CataUserDemo**" + dataUserDemo);
    }


    /*
        check @NoArgsConstructor and @AllArgsConstructor annotations
    */
    public void checkConstructorAnnotation() {
        ConstructorUserDemo constructorUserDemoNoArgs=new ConstructorUserDemo();
        System.out.println("**ConstructorUserDemo with NoArgsConstructor**" + constructorUserDemoNoArgs);
        ConstructorUserDemo constructorUserDemoAllArgs=new ConstructorUserDemo(101, "John Doe" , 25);
        System.out.println("**ConstructorUserDemo with AllArgsConstructor**" + constructorUserDemoAllArgs);

    }


}
