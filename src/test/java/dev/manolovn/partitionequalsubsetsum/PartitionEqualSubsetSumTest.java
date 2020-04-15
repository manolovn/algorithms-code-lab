package dev.manolovn.partitionequalsubsetsum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PartitionEqualSubsetSumTest {

    @Parameters(name = "{index}: subsetEqualSum({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, false},
                {new int[]{1, 5, 5, 11}, true},
                {new int[]{1, 11, 5, 5}, true},
                {new int[]{11, 5, 5}, false},
        });
    }

    private int[] input;
    private boolean expected;

    public PartitionEqualSubsetSumTest(int[] input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, PartitionEqualSubsetSum.canPartition(input));
        assertEquals(expected, PartitionEqualSubsetSum.canPartition_withDP(input));
    }
}
