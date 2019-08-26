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
        test @Data annotation for getter and setter
    */
    @Test
    public void testDataAnnotationForGetterandSetter() {
        dataUserDemo.setUserId(101);
        dataUserDemo.setUserName("John Doe");
        dataUserDemo.setUserAge(25);
        assertEquals(101, dataUserDemo.getUserId());
        assertEquals( "John Doe", dataUserDemo.getUserName());
        assertEquals( 25, dataUserDemo.getUserAge());
        System.out.println(dataUserDemo);
    }

    /*
        test @Data annotation for toString
    */
    @Test
    public void testDataAnnotationForToString() {
        dataUserDemo.setUserId(101);
        dataUserDemo.setUserName("John Doe");
        dataUserDemo.setUserAge(25);
        assertTrue(dataUserDemo.toString().startsWith(DataUserDemo.class.getSimpleName()));
        assertTrue(dataUserDemo.toString().endsWith("(userId=101, userName=John Doe, userAge=25)"));
    }

    /*
        test @Data annotation for equalsAndHashcode
    */
    @Test
    public void testDataAnnotationForEqualsAndHashCode() {
        DataUserDemo dataUserDemo1 = new DataUserDemo();
        DataUserDemo dataUserDemo2 = new DataUserDemo();
        assertTrue((dataUserDemo1).equals(dataUserDemo2));
        assertEquals(dataUserDemo1.hashCode(),dataUserDemo2.hashCode());
    }
}