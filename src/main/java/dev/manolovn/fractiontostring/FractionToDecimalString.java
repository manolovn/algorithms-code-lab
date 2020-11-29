package dev.manolovn.fractiontostring;

import java.util.HashMap;
import java.util.Map;

/**
 * source: https://leetcode.com/problems/fraction-to-recurring-decimal/
 * difficulty: MEDIUM
 * topic: ARRAY + MATH + KMP
 */
public class FractionToDecimalString {

    /*
    1/2 => 0.5
    2/1 => 2
    2/3 => 0.(6)
    4/333 => O.(012)
    1/5 => 0.2

    1/2 = 0.5
    2/3 = 0.66666666
    4/333 = 0.012012012012

    1. make the operation, int -> double
    2. result of division -> string
    3. find the repeated number from "."
        0.660660660660
        0.666666666666
          ^

    */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(dividend / divisor);

        long remainder = dividend % divisor;
        if (remainder == 0) return fraction.toString();

        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
