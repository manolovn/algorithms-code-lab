package dev.manolovn.shiftedarraysearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShiftedArraySearchTest {

    @Parameters(name = "{index}: shiftedArrSearch({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2}, 2, 0},
                {new int[]{1, 2}, 2, 1},
                {new int[]{0, 1, 2, 3, 4, 5}, 1, 1},
                {new int[]{1, 2, 3, 4, 5, 0}, 0, 5},
                {new int[]{9, 12, 17, 2, 4, 5}, 17, 2},
                {new int[]{9, 12, 17, 2, 4, 5, 6}, 4, 4},
        });
    }

    private int[] input;
    private int k;
    private int expected;

    public ShiftedArraySearchTest(int[] input, int k, int expected) {
        this.input = input;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, ShiftedArraySearch.shiftedArrSearch(input, k));
    }
}
