package dev.manolovn.arrayofarrayproducts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ArrayOfArrayProductsTest {

    @Parameters(name = "{index}: arrayOfArrayProducts({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{}},
                {new int[]{2, 2}, new int[]{2, 2}},
                {new int[]{2, 7, 3, 4}, new int[]{84, 24, 56, 42}},
                {new int[]{2, 3, 0, 982, 10}, new int[]{0, 0, 58920, 0, 0}},
                {
                        new int[]{-3, 17, 430, -6, 5, -12, -11, 5},
                        new int[]{-144738000, 25542000, 1009800, -72369000, 86842800, -36184500, -39474000, 86842800}
                },
        });
    }

    private int[] input;
    private int[] expected;

    public ArrayOfArrayProductsTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        int[] output = ArrayOfArrayProducts.arrayOfArrayProducts(input);
        assertArrayEquals(expected, output);
    }
}
