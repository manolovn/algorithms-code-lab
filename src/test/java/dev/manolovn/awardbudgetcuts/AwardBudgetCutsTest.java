package dev.manolovn.awardbudgetcuts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AwardBudgetCutsTest {

    @Parameters(name = "{index}: findGrantsCap({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new double[]{2, 4}, 3, 1.5},
                {new double[]{2, 4, 6}, 3, 1},
                {new double[]{2, 100, 50, 120, 167}, 400, 128},
                {new double[]{2, 100, 50, 120, 1000}, 190, 47},
                {new double[]{21, 100, 50, 120, 130, 110}, 140, 23.8},
                {new double[]{210, 200, 150, 193, 130, 110, 209, 342, 117}, 1530, 211},
        });
    }

    private double[] input;
    private double newBudget;
    private double expected;

    public AwardBudgetCutsTest(double[] input, double newBudget, double expected) {
        this.input = input;
        this.newBudget = newBudget;
        this.expected = expected;
    }

    @Test
    public void test() {
        double output = AwardBudgetCuts.findGrantsCap(input, newBudget);
        assertEquals(expected, output, 0.0);
    }
}
