package dev.manolovn.sentencereverser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SentenceReverserTest {

    @Parameters(name = "{index}: reverseWords({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'},
                        new char[]{'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't'}
                },
                {
                        new char[]{' ', ' '},
                        new char[]{' ', ' '}
                },
                {
                        new char[]{'a', ' ', ' ', 'b'},
                        new char[]{'b', ' ', ' ', 'a'}
                },
                {
                        new char[]{'h', 'e', 'l', 'l', 'o'},
                        new char[]{'h', 'e', 'l', 'l', 'o'}
                },
                {
                        new char[]{'y', 'o', 'u', ' ', 'w', 'i', 't', 'h', ' ', 'b', 'e', ' ', 'f', 'o', 'r', 'c', 'e', ' ', 't', 'h', 'e', ' ', 'm', 'a', 'y'},
                        new char[]{'m', 'a', 'y', ' ', 't', 'h', 'e', ' ', 'f', 'o', 'r', 'c', 'e', ' ', 'b', 'e', ' ', 'w', 'i', 't', 'h', ' ', 'y', 'o', 'u'}
                },
                {
                        new char[]{'g', 'r', 'e', 'a', 't', 'e', 's', 't', ' ', 'n', 'a', 'm', 'e', ' ', 'f', 'i', 'r', 's', 't', ' ', 'e', 'v', 'e', 'r', ' ', 'n', 'a', 'm', 'e', ' ', 'l', 'a', 's', 't'},
                        new char[]{'l', 'a', 's', 't', ' ', 'n', 'a', 'm', 'e', ' ', 'e', 'v', 'e', 'r', ' ', 'f', 'i', 'r', 's', 't', ' ', 'n', 'a', 'm', 'e', ' ', 'g', 'r', 'e', 'a', 't', 'e', 's', 't'},
                }
        });
    }

    private char[] input;
    private char[] expected;

    public SentenceReverserTest(char[] input, char[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        char[] output = SentenceReverser.reverseWords(input);
        assertArrayEquals(expected, output);
    }
}
