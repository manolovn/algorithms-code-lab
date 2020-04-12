package dev.manolovn.deletiondistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DeletionDistanceTest {

    @Parameters(name = "{index}: deletionDistance({0},{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"", "", 0},
                {"", "hit", 3},
                {"neat", "", 4},
                {"heat", "hit", 3},
                {"hot", "not", 2},
                {"some", "thing", 9},
                {"abc", "adbc", 1},
                {"awesome", "awesome", 0},
                {"ab", "ba", 2},
        });
    }

    private String input;
    private String input2;
    private int expected;

    public DeletionDistanceTest(String input, String input2, int expected) {
        this.input = input;
        this.input2 = input2;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, DeletionDistance.deletionDistance(input, input2));
    }
}
