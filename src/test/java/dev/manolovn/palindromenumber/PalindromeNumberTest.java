package dev.manolovn.palindromenumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PalindromeNumberTest {

    @Parameters(name = "{index}: isPalindrome({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {121, true},
                {-121, false},
                {0, true},
                {10, false},
                {10001, true},
        });
    }

    private int input;
    private boolean expected;

    public PalindromeNumberTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, PalindromeNumber.isPalindrome(input));
    }
}
