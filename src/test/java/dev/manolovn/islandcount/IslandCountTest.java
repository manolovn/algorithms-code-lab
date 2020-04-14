package dev.manolovn.islandcount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IslandCountTest {

    @Parameters(name = "{index}: getNumberOfIslands({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{0}}, 0},
                {new int[][]{{1}}, 1},
                {new int[][]{{1, 0, 1, 0}}, 2},
                {new int[][]{{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}}, 2},
                {new int[][]{{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 1, 0, 1}}, 4},
                {new int[][]{{0, 1, 0, 1, 0}, {0, 0, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}}, 6},
                {new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}, 1},
        });
    }

    private int[][] input;
    private int expected;

    public IslandCountTest(int[][] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, IslandCount.getNumberOfIslands(input));
    }
}
