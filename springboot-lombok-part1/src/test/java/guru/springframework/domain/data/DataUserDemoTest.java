package guru.springframework.domain.data;

import guru.springframework.domain.constructor.ConstructorUserDemo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DataUserDemoTest {
    DataUserDemo dataUserDemo;

    @Before
    public void setUp() throws Exception {
        dataUserDemo = new DataUserDemo();
    }

    @After
    public void tearDown() throws Exception {
        dataUserDemo = null;
    }

    /*
        test @Data annotation
    */
    @Test
    public void testDataAnnotationForDataUserDemo() {
        dataUserDemo.setUserId(101);
        dataUserDemo.setUserName("John Doe");
        dataUserDemo.setUserAge(25);
        assertEquals(101, dataUserDemo.getUserId());
        assertEquals( "John Doe", dataUserDemo.getUserName());
        assertEquals( 25, dataUserDemo.getUserAge());
        System.out.println(dataUserDemo);
    }
}