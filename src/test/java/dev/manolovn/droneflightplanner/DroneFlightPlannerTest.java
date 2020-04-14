package dev.manolovn.droneflightplanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DroneFlightPlannerTest {

    @Parameters(name = "{index}: calcDroneMinEnergy({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{0, 1, 19}}, 0},
                {new int[][]{{0, 2, 10}, {10, 10, 8}}, 0},
                {new int[][]{{0, 2, 6}, {10, 10, 20}}, 14},
                {new int[][]{{0, 2, 10}, {3, 5, 0}, {9, 20, 6}, {10, 12, 15}, {10, 10, 8}}, 5},
                {new int[][]{{0, 2, 2}, {3, 5, 38}, {9, 20, 6}, {10, 12, 15}, {10, 10, 8}}, 36},
                {new int[][]{{0, 2, 10}, {3, 5, 9}, {9, 20, 6}, {10, 12, 2}, {10, 10, 10}, {10, 10, 2}}, 0},
        });
    }

    private int[][] input;
    private int expected;

    public DroneFlightPlannerTest(int[][] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, DroneFlightPlanner.calcDroneMinEnergy(input));
    }
}
