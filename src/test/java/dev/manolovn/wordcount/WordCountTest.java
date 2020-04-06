package dev.manolovn.wordcount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class WordCountTest {

    @Parameters(name = "{index}: wordCountEngine({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "Practice makes perfect. you'll only get Perfect by practice. just practice!",
                        new String[][]{
                                new String[]{"practice", "3"},
                                new String[]{"perfect", "2"},
                                new String[]{"makes", "1"},
                                new String[]{"youll", "1"},
                                new String[]{"only", "1"},
                                new String[]{"get", "1"},
                                new String[]{"by", "1"},
                                new String[]{"just", "1"}
                        }
                }
        });
    }

    private String input;
    private String[][] expected;

    public WordCountTest(String input, String[][] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        String[][] output = WordCount.wordCountEngine(input);
        assertArrayEquals(expected, output);
    }
}
