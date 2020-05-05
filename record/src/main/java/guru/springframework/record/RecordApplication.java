package guru.springframework.record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordApplication.class, args);

        Product product1 = new Product("bread", 1.50);
        System.out.println(product1.name());
        System.out.println(product1.price());
        System.out.println(product1.toString());

        Product product2 = new Product("apple", 1.50);

        System.out.println(product1 == product2);
        System.out.println(product1.equals(product2));

        ExplicitMemberProduct explicitMemberProduct = new ExplicitMemberProduct("milk", 2.50);
        System.out.println(explicitMemberProduct.name());

        ExplicitConstructorProduct explicitConstructorProduct = new ExplicitConstructorProduct("soap", 3.00);
        System.out.println(explicitConstructorProduct.toString());
    }

}
