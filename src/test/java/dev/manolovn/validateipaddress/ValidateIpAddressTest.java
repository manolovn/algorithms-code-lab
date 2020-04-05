package dev.manolovn.validateipaddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValidateIpAddressTest {

    @Parameters(name = "{index}: validateIP({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"192.168.0.1",     true},
                {"0.0.0.0",         true},
                {"123.24.59.99",    true},
                {"192.168.123.456", false},
                {"12.34.5.6",       true},
                {"0.23.25.0",       true},
                {"255.255.255.255", true},
                {"12.34.56.oops",   false},
                {"1.2.3.4.5",       false},
                {"123.235.153.425", false},
        });
    }

    private String input;
    private boolean expected;

    public ValidateIpAddressTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        boolean output = ValidateIpAddress.validateIP(input);
        assertEquals(expected, output);
    }
}
