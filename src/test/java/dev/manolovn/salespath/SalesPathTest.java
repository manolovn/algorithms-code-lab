package dev.manolovn.salespath;

import dev.manolovn.salespath.SalesPath.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SalesPathTest {

    @Parameters(name = "{index}: getCheapestCost({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                TestInput.input0(),
        });
    }

    private Node input;
    private int expected;

    public SalesPathTest(Node input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        SalesPath sut = new SalesPath();
        int output = sut.getCheapestCost(input);
        assertEquals(expected, output);
    }
}
