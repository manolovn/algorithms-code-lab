package dev.manolovn.findtheduplicates;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class FindTheDuplicatesTest {

    @Parameters(name = "{index}: findDuplicates({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{11}, new int[]{11}, new int[]{11}},
                {new int[]{1, 3, 5, 9}, new int[]{2, 4, 6, 10}, new int[]{}},
                {new int[]{1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20}, new int[]{3, 6, 7}},
                {new int[]{1, 2, 3, 5, 6, 7}, new int[]{7, 8, 9, 10, 11, 12}, new int[]{7}},
                {new int[]{10, 20, 30, 40, 50, 60, 70, 80}, new int[]{10, 20, 30, 40, 50, 60}, new int[]{10, 20, 30, 40, 50, 60}},
                {new int[]{10, 20, 30, 40, 50, 60, 70}, new int[]{10, 20, 30, 40, 50, 60, 70}, new int[]{10, 20, 30, 40, 50, 60, 70}},
        });
    }

    private int[] input;
    private int[] input2;
    private int[] expected;

    public FindTheDuplicatesTest(int[] input, int[] input2, int[] expected) {
        this.input = input;
        this.input2 = input2;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertArrayEquals(expected, FindTheDuplicates.findDuplicates(input, input2));
    }
}
