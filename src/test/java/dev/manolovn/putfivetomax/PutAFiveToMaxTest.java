package dev.manolovn.putfivetomax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PutAFiveToMaxTest {

    @Parameters(name = "{index}: putAFive({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 0, 50 },
                { 289, 5289 },
                { 999, 9995 },
                { 732, 7532 },
                { -99, -599 },
        });
    }

    private int input;
    private int expected;

    public PutAFiveToMaxTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, PutAFiveToMax.putAFive(input));
    }
}
