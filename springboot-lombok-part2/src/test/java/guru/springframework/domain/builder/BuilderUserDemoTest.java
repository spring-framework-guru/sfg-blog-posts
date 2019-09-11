package guru.springframework.domain.builder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderUserDemoTest {
    private BuilderUserDemo builderUserDemo;
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