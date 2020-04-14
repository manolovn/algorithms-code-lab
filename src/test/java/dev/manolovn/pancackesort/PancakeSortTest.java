package dev.manolovn.pancackesort;

import dev.manolovn.pancakesort.PancakeSort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class PancakeSortTest {

    @Parameterized.Parameters(name = "{index}: pancakeSort({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 3, 1}, new int[]{1, 1, 3}},
                {new int[]{3, 1, 2, 4, 6, 5}, new int[]{1, 2, 3, 4, 5, 6}},
                {new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}},
                {new int[]{10, 9, 8, 6, 7, 5, 4, 3, 2, 1, 9, 10, 8, 7, 6, 5, 4, 3, 2, 1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10}},
        });
    }

    private int[] input;
    private int[] expected;

    public PancakeSortTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertArrayEquals(expected, PancakeSort.pancakeSort(input));
    }
}
