package guru.springframework.gradlelombok;

import guru.springframework.gradlelombok.domain.Job;
import guru.springframework.gradlelombok.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradlelombokApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradlelombokApplication.class, args);

        Job furnitureCarpenter = new Job("carpenter");
        furnitureCarpenter.setPosition("furniture");
        furnitureCarpenter.setSalary(2500d);

        Job sculptorCarpenter = new Job("carpenter");
        sculptorCarpenter.setPosition("sculptor");
        sculptorCarpenter.setSalary(2500d);

        System.out.println(furnitureCarpenter);
        System.out.println(sculptorCarpenter);

        System.out.println("Sculptor and furniture carpenters objects are the same -> " + (furnitureCarpenter == sculptorCarpenter));
        System.out.println("Sculptor and furniture carpenters are the same -> " + furnitureCarpenter.equals(sculptorCarpenter));
        System.out.println("Hash codes -> " + (furnitureCarpenter.hashCode() == sculptorCarpenter.hashCode()));

        sculptorCarpenter.setPosition("furniture");
        System.out.println("Sculptor carpenter new specialization -> " + sculptorCarpenter.getPosition());

        System.out.println("Sculptor and furniture carpenters objects are the same -> " + (furnitureCarpenter == sculptorCarpenter));
        System.out.println("Sculptor and furniture carpenters are the same -> " + furnitureCarpenter.equals(sculptorCarpenter));
        System.out.println("Hash codes -> " + (furnitureCarpenter.hashCode() == sculptorCarpenter.hashCode()));

        Person emily = Person.builder()
                             .firstname("Emily")
                             .surname("Stoke")
                             .age(25)
                             .height(172)
                             .job(furnitureCarpenter)
                             .build();

        System.out.println(emily);
    }

}
