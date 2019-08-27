package guru.springframework.domain.valandvar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ValAndVarUserDemoTest {
    private ValAndVarUserDemo valAndVarUserDemo;
    @Before
    public void setUp() throws Exception {
        valAndVarUserDemo=new ValAndVarUserDemo();
    }
    @After
    public void tearDown() throws Exception {
        valAndVarUserDemo=null;
    }

    @Test
    public void testValUsage(){
        assertEquals("hello world",valAndVarUserDemo.valCheck());
    }

    @Test
    public void testVarUsage(){
        assertEquals(new BigDecimal(80),valAndVarUserDemo.varCheck());
    }
}