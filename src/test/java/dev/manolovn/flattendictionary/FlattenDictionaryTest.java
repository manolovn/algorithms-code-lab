package dev.manolovn.flattendictionary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FlattenDictionaryTest {

    @Parameters(name = "{index}: flattenDictionary({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                TestInput.case1(),
                TestInput.case2(),
                TestInput.case3(),
                TestInput.case4(),
                TestInput.case5(),
                TestInput.case6()
        );
    }

    private HashMap<String, Object> input;
    private Map<String, String> expected;

    public FlattenDictionaryTest(HashMap<String, Object> input, Map<String, String> expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, FlattenDictionary.flattenDictionary(input));
    }
}
