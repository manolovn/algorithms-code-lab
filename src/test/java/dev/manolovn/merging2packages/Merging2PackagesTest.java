package dev.manolovn.merging2packages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class Merging2PackagesTest {

    @Parameters(name = "{index}: getIndicesOfItemWeights({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4, 6, 10, 15, 16}, 21, new int[]{3, 1}},
                {new int[]{2, 6, 15, -1}, 1, new int[]{3, 0}},
                {new int[]{2, 6, -1, -1}, 1, new int[]{2, 0}},
        });
    }

    private int[] input;
    private int limit;
    private int[] expected;

    public Merging2PackagesTest(int[] input, int limit, int[] expected) {
        this.input = input;
        this.limit = limit;
        this.expected = expected;
    }

    @Test
    public void test() {
        Merging2Packages sut = new Merging2Packages();
        int[] output = sut.getIndicesOfItemWeights(input, limit);
        assertArrayEquals(expected, output);
    }
}
