package dev.manolovn.matrixspiralcopy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class MatrixSpiralCopyTest {

    @Parameters(name = "{index}: spiralCopy({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1}}, new int[]{1}},
                {new int[][]{{1}, {2}}, new int[]{1, 2}},
                {new int[][]{{1, 2}}, new int[]{1, 2}},
                {new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2, 4, 3}},
                {new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}, new int[]{1, 2, 3, 4, 5, 10, 9, 8, 7, 6}},
                {new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}}, new int[]{1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12}},
        });
    }

    private int[][] input;
    private int[] expected;

    public MatrixSpiralCopyTest(int[][] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertArrayEquals(expected, MatrixSpiralCopy.spiralCopy(input));
    }
}
