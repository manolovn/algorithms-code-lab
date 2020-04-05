package dev.manolovn.diffbetweentwostrings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class DiffBetweenTwoStringsTest {

    @Parameters(name = "{index}: diffBetweenTwoStrings({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFG", "ABDFFGH", new String[]{"A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"}},
        });
    }

    private String input;
    private String target;
    private String[] expected;

    public DiffBetweenTwoStringsTest(String input, String target, String[] expected) {
        this.input = input;
        this.target = target;
        this.expected = expected;
    }

    @Test
    public void test() {
        String[] output = DiffBetweenTwoStrings.diffBetweenTwoStrings(input, target);
        assertArrayEquals(expected, output);
    }
}
