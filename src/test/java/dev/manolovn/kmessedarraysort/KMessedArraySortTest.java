package dev.manolovn.kmessedarraysort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class KMessedArraySortTest {

    @Parameters(name = "{index}: sortKMessedArray({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 0, new int[]{1}},
                {new int[]{1, 0}, 1, new int[]{0, 1}},
                {new int[]{1, 0, 3, 2}, 1, new int[]{0, 1, 2, 3}},
                {new int[]{1, 0, 3, 2, 4, 5, 7, 6, 8}, 1, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new int[]{6, 1, 4, 11, 2, 0, 3, 7, 10, 5, 8, 9}, 6, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}},
        });
    }

    private int[] input;
    private int k;
    private int[] expected;

    public KMessedArraySortTest(int[] input, int k, int[] expected) {
        this.input = input;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertArrayEquals(expected, KMessedArraySort.sortKMessedArray(input, k));
    }
}
