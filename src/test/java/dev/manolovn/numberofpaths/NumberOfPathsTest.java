package dev.manolovn.numberofpaths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberOfPathsTest {

    @Parameters(name = "{index}: numOfPathsToDest({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 5},
                {6, 42},
                {17, 35357670},
        });
    }

    private int input;
    private int expected;

    public NumberOfPathsTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, NumberOfPaths.numOfPathsToDest(input));
    }
}
