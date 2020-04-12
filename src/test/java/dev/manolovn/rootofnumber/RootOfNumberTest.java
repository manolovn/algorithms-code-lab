package dev.manolovn.rootofnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RootOfNumberTest {

    @Parameters(name = "{index}: root({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 2, 2},
                {27, 3, 3},
                {16, 4, 2},
                {3, 2, 1.732},
                {10, 3, 2.154},
                {160, 3, 5.429},
        });
    }

    private double input;
    private int n;
    private double expected;

    public RootOfNumberTest(double input, int n, double expected) {
        this.input = input;
        this.n = n;
        this.expected = expected;
    }

    @Test
    public void test() {
        double output = RootOfNumber.root(input, n);
        assertEquals(expected, output, 0.001);
    }
}
