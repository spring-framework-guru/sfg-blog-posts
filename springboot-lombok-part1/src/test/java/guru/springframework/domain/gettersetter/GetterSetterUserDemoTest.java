package guru.springframework.domain.gettersetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetterSetterUserDemoTest {

    private GetterSetterUserDemo getterSetterUserDemo;
    @Before
    public void setUp(){
        getterSetterUserDemo=new GetterSetterUserDemo();
    }
    @After
    public void tearDown(){
        getterSetterUserDemo=null;
    }
    @Test
    public void testGetterSetterAnnotation() {
        getterSetterUserDemo.setUserId(101);
        getterSetterUserDemo.setUserName("John Doe");
        getterSetterUserDemo.setUserAge(25);
        assertEquals(101, getterSetterUserDemo.getUserId());
        assertEquals( "John Doe", getterSetterUserDemo.getUserName());
        assertEquals( 25, getterSetterUserDemo.getUserAge());

    }
}