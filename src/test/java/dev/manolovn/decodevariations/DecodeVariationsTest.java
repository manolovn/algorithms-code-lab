package dev.manolovn.decodevariations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DecodeVariationsTest {

    @Parameters(name = "{index}: decodeVariations({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1262", 3},
                {"26", 2},
                {"127", 2},
                {"1270", 0},
                {"83778549129", 2},
                {"8254779486", 2},
                {"122231131122", 120},
                {"122212313113", 126},
                {"321121311231", 65},
        });
    }

    private String input;
    private int expected;

    public DecodeVariationsTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, DecodeVariations.decodeVariations(input));
    }
}
