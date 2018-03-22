package codingnomads;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstTestTest {
    FirstTest tester = new FirstTest();

    @Test
    public void muliply() throws Exception {
        assertEquals(4, tester.muliply(2, 2));
    }
}