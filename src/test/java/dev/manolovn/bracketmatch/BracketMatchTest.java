package dev.manolovn.bracketmatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BracketMatchTest {

    @Parameters(name = "{index}: bracketMatch({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {")", 1},
                {"(", 1},
                {"(())", 0},
                {"(()", 1},
                {"())(", 2},
                {"))))", 4},
                {")(", 2},
                {"()()()()()", 0},
        });
    }

    private String input;
    private int expected;

    public BracketMatchTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, BracketMatch.bracketMatch(input));
    }
}
