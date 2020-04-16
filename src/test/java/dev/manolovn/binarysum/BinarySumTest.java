package dev.manolovn.binarysum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinarySumTest {

    @Parameters(name = "{index}: binarySum({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"11", "1", "100"},
                {"1010", "1011", "10101"},
        });
    }

    private String input;
    private String input2;
    private String expected;

    public BinarySumTest(String input, String input2, String expected) {
        this.input = input;
        this.input2 = input2;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, BinarySum.binarySum(input, input2));
    }
}
