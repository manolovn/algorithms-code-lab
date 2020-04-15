package dev.manolovn.romantointeger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RomanToIntegerTest {

    @Parameters(name = "{index}: romanToInt({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"III", 3},
                {"IV", 4},
                {"IX", 9},
                {"LVIII", 58},
                {"MCMXCIV", 1994},
        });
    }

    private String input;
    private int expected;

    public RomanToIntegerTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, RomanToInteger.romanToInt(input));
    }
}
