package guru.springframework.domain.builder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderUserDemoTest {
    BuilderUserDemo builderUserDemo;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
        test @Builder annotation
    */
    @Test
    public void testBuilderAnnotationForBuilderUserDemo() {
        builderUserDemo = BuilderUserDemo.builder()
                .userId(100)
                .userName("John Doe")
                .userAge(25)
                .build();

        System.out.println(builderUserDemo.toBuilder());

        assertEquals(100, builderUserDemo.getUserId());
        assertEquals("John Doe", builderUserDemo.getUserName());
        assertEquals(25, builderUserDemo.getUserAge());
    }
}