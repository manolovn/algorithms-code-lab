package dev.manolovn.decryptmessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DecryptMessageTest {

    @Parameters(name = "{index}: decrypt({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"dnotq", "crime"},
                {"flgxswdliefy", "encyclopedia"},
                {"rajsb", "qqqqq"},
                {"bvqmjhgghjmqvbiqzjugthwmdv", "abcdefghijklmnopqrstuvwxyz"},
                {"eobamwpnlmhklrq", "drugtrafficking"},
                {"", ""},
        });
    }

    private String input;
    private String expected;

    public DecryptMessageTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, DecryptMessage.decrypt(input));
    }
}
