package guru.springframework.domain.constructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorUserDemoTest {

    private ConstructorUserDemo constructorUserDemo;
    /*
         test @NoArgsConstructor annotation
     */
    @Test
    public void testDataAnnotationForNoArgsConstructor() {
        constructorUserDemo = new ConstructorUserDemo();
        assertNotNull(constructorUserDemo);

    }

    /*
        test @AllArgsConstructor annotation
    */
    @Test
    public void testDataAnnotationForAllArgsConstructor() {
        constructorUserDemo = new ConstructorUserDemo(100, "John Doe", 25);
        assertNotNull(constructorUserDemo);

    }

}