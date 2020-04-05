package dev.manolovn.timeplanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class TimePlannerTest {

    @Parameters(name = "{index}: meetingPlanner({0},{1},{2})={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                TestInput.input0(),
                TestInput.input1(),
                TestInput.input2(),
                TestInput.input3(),
                TestInput.input4(),
                TestInput.input5(),
                TestInput.input6()
        );
    }

    private int[][] slotsA;
    private int[][] slotsB;
    private int duration;
    private int[] expected;

    public TimePlannerTest(int[][] slotsA, int[][] slotsB, int duration, int[] expected) {
        this.slotsA = slotsA;
        this.slotsB = slotsB;
        this.duration = duration;
        this.expected = expected;
    }

    @Test
    public void test() {
        int[] output = TimePlanner.meetingPlanner(slotsA, slotsB, duration);
        assertArrayEquals(expected, output);
    }
}
