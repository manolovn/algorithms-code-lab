package dev.manolovn.basicregexparser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BasicRegexParserTest {

    @Parameters(name = "{index}: isMatch({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", "", true},
                {"aa", "a", false},
                {"bb", "bb", true},
                {"", "a*", true},
                {"abbdbb", "ab*d", false},
                {"aba", "a.a", true},
                {"acd", "ab*c.", true},
                {"abaa", "a.*a*", true},
        });
    }

    private String input;
    private String pattern;
    private boolean expected;

    public BasicRegexParserTest(String input, String pattern, boolean expected) {
        this.input = input;
        this.pattern = pattern;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, BasicRegexParser.isMatch(input, pattern));
    }
}
