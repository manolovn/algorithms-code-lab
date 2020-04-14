package dev.manolovn.gettingadifferentnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GettingADifferentNumberTest {

    @Parameters(name = "{index}: getDifferentNumber({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0}, 1},
                {new int[]{0, 1, 2}, 3},
                {new int[]{1, 3, 0, 2}, 4},
                {new int[]{100000}, 0},
                {new int[]{1, 0, 3, 4, 5}, 2},
                {new int[]{0, 100000}, 1},
                {new int[]{0, 99999, 100000}, 1},
                {new int[]{0, 5, 4, 1, 3, 6, 2}, 7},
        });
    }

    private int[] input;
    private int expected;

    public GettingADifferentNumberTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, GettingADifferentNumber.getDifferentNumber(input));
    }
}
