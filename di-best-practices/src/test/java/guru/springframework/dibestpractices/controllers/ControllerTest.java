package guru.springframework.dibestpractices.controllers;

import guru.springframework.dibestpractices.controllers.bp.BpFinalConstructorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControllerTest {

    @Autowired
    FieldController fieldController;

    @Autowired
    PrivateFieldController privateFieldController;

    @Autowired
    SetterController setterController;

    @Autowired
    ConstructorController  constructorController;

    @Autowired
    BpFinalConstructorController bpFinalConstructorController;

    @Test
    void tesFieldController() {
        System.out.println("A field Controller says: " + fieldController.saySomething());

        System.out.println("A private field Controller says: " + privateFieldController.saySomething());

        System.out.println("A Setter Controller says: " + setterController.saySomething());

        System.out.println("A Constructor Controller says: " + constructorController.saySomething());

        System.out.println("Best Practice Controller says: " + bpFinalConstructorController.saySomething());

    }
}