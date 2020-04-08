package dev.manolovn.busiestmall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BusiestTimeInTheMallTest {

    @Parameters(name = "{index}: findBusiestPeriod({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        new int[]{1487799425, 14, 1},
                        new int[]{1487799425, 4, 0},
                        new int[]{1487799425, 2, 0},
                        new int[]{1487800378, 10, 1},
                        new int[]{1487801478, 18, 0},
                        new int[]{1487801478, 18, 1},
                        new int[]{1487901013, 1, 0},
                        new int[]{1487901211, 7, 1},
                        new int[]{1487901211, 7, 0}
                }, 1487800378},
        });
    }

    private int[][] input;
    private int expected;

    public BusiestTimeInTheMallTest(int[][] input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        int output = BusiestTimeInTheMall.findBusiestPeriod(input);
        assertEquals(expected, output);
    }
}
