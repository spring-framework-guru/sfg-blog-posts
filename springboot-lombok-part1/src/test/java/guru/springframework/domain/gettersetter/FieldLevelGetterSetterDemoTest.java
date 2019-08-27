package guru.springframework.domain.gettersetter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldLevelGetterSetterDemoTest {

    FieldLevelGetterSetterDemo fieldLevelGetterSetterDemo;
    @Before
    public void setUp() throws Exception {
        fieldLevelGetterSetterDemo=new FieldLevelGetterSetterDemo(28);
    }

    @After
    public void tearDown() throws Exception {
        fieldLevelGetterSetterDemo=null;
    }

    @Test
    public void testFieldLevelGetterSetter(){
        fieldLevelGetterSetterDemo.setUserName("John Doe");
        assertEquals( "John Doe", fieldLevelGetterSetterDemo.getUserName());
    }
    @Test
    public void testFieldLevelGetter(){
       assertEquals( 28, fieldLevelGetterSetterDemo.getUserAge());
    }
}