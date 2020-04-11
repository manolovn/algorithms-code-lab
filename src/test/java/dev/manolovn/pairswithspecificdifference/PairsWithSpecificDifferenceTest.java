package dev.manolovn.pairswithspecificdifference;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class PairsWithSpecificDifferenceTest {

    @Parameterized.Parameters(name = "{index}: findPairsWithGivenDifference({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4, 1}, 3, new int[][]{new int[]{4, 1}}},
                {new int[]{1, 5, 11, 7}, 4, new int[][]{new int[]{5, 1}, new int[]{11, 7}}},
                {new int[]{1, 5, 11, 7}, 6, new int[][]{new int[]{7, 1}, new int[]{11, 5}}},
                {new int[]{1, 5, 11, 7}, 10, new int[][]{new int[]{11, 1}}},
                {new int[]{0, -1, -2, 2, 1}, 1, new int[][]{new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, -2}, new int[]{2, 1}}},
                {new int[]{1, 7, 5, 3, 32, 17, 12}, 17, new int[][]{}},
        });
    }

    private int[] input;
    private int k;
    private int[][] expected;

    public PairsWithSpecificDifferenceTest(int[] input, int k, int[][] expected) {
        this.input = input;
        this.k = k;
        this.expected = expected;
    }

    @Test
    public void test() {
        int[][] output = PairsWithSpecificDifference.findPairsWithGivenDifference(input, k);
        assertArrayEquals(expected, output);
    }
}
