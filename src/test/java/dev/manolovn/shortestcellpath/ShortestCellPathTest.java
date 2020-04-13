package dev.manolovn.shortestcellpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShortestCellPathTest {

    @Parameters(name = "{index}: shortestCellPath({0},{1},{2},{3},{4})={5}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}}, 0, 0, 2, 0, 8},
                {new int[][]{{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 1, 1}}, 0, 0, 2, 0, -1},
                {new int[][]{{0, 1, 0}, {1, 0, 0}, {1, 0, 1}}, 2, 0, 1, 0, 1},
                {new int[][]{{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}, 0, 1, 0, 0, 1},
                {new int[][]{{1, 0, 1, 1}, {1, 0, 1, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}}, 1, 3, 0, 0, -1},
                {new int[][]{{1, 0, 1, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {1, 0, 0, 1, 1}}, 0, 3, 3, 1, -1},
                {new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 1, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 0}, {0, 0, 1, 1, 1}}, 3, 0, 0, 3, -1},
                {new int[][]{{1, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}}, 5, 4, 2, 1, -1},
                {new int[][]{{1, 1, 0, 0, 1, 0}, {1, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 1}, {0, 0, 1, 1, 0, 0}}, 3, 0, 1, 3, -1},
        });
    }

    private int[][] input;
    private int sx;
    private int sy;
    private int ex;
    private int ey;
    private int expected;

    public ShortestCellPathTest(int[][] input, int sx, int sy, int ex, int ey, int expected) {
        this.input = input;
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, ShortestCellPath.shortestCellPath(input, sx, sy, ex, ey));
    }
}
