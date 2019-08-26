package guru.springframework.domain.constructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorUserDemoTest {

    ConstructorUserDemo constructorUserDemo;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
        test @NoArgsConstructor and @AllArgsConstructor annotation
    */
    @Test
    public void testDataAnnotationForConstructor() {
        constructorUserDemo = new ConstructorUserDemo(100, "John Doe", 25);
    }

}