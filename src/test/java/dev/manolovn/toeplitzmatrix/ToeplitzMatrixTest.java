package dev.manolovn.toeplitzmatrix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ToeplitzMatrixTest {

    @Parameters(name = "{index}: isToeplitz({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{4, 0}, {9, 4}}, true},
                {new int[][]{{6, 4, 4}}, true},
                {new int[][]{{3}, {5}, {6}}, true},
                {new int[][]{{3, 9}, {5, 3}, {6, 5}}, true},
                {new int[][]{{3, 1, 7}, {4, 1, 1}, {2, 4, 3}}, false},
                {new int[][]{{8, 8, 8, 8, 8}, {8, 8, 8, 8, 9}, {8, 8, 8, 8, 8}, {8, 8, 8, 8, 8}, {8, 8, 8, 8, 8}}, false},
        });
    }

    private int[][] input;
    private boolean expected;

    public ToeplitzMatrixTest(int[][] input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, ToeplitzMatrix.isToeplitz(input));
    }
}
