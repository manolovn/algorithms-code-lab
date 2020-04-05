package dev.manolovn.movezerostoend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class MoveZerosToEndTest {

    @Parameterized.Parameters(name = "{index}: moveZerosToEnd({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new int[]{1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0},
                        new int[]{1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0}
                },
                {
                        new int[]{1, 10, 0, 2, 8},
                        new int[]{1, 10, 2, 8, 0}
                },
        });
    }

    private int[] input;
    private int[] expected;

    public MoveZerosToEndTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        int[] output = MoveZerosToEnd.moveZerosToEnd(input);
        assertArrayEquals(expected, output);
    }
}
