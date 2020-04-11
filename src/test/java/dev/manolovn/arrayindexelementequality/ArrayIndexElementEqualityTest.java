package dev.manolovn.arrayindexelementequality;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArrayIndexElementEqualityTest {

    @Parameters(name = "{index}: indexEqualsValueSearch({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0}, 0},
                {new int[]{0, 3}, 0},
                {new int[]{-8, 0, 1, 3, 5}, 3},
                {new int[]{-5, 0, 2, 3, 10, 29}, 2},
                {new int[]{-5, 0, 3, 4, 10, 18, 27}, -1},
                {new int[]{-6, -5, -4, -1, 1, 3, 5, 7}, 7},
        });
    }

    private int[] input;
    private int expected;

    public ArrayIndexElementEqualityTest(int[] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        int output = ArrayIndexElementEquality.indexEqualsValueSearch(input);
        assertEquals(expected, output);
    }
}
