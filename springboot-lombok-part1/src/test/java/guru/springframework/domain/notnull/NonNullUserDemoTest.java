package guru.springframework.domain.notnull;

import org.junit.Test;

import static org.junit.Assert.*;
public class NonNullUserDemoTest {
    private NonNullUserDemo nonNullUserDemo;
   @Test(expected = NullPointerException.class)
    public void testNonNullOnConstruuctorParameter(){
        nonNullUserDemo= new NonNullUserDemo(50, null,25);
    }
}