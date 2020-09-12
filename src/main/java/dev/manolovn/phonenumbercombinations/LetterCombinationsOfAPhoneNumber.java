package dev.manolovn.phonenumbercombinations;

import java.util.*;

/**
 * source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * difficulty: MEDIUM
 * topic: RECURSION & BACKTRACKING
 */
public class LetterCombinationsOfAPhoneNumber {

    private final Map<Character, String> keyboard = new HashMap<Character, String>() {{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) return Collections.emptyList();

        List<String> combinations = new ArrayList<>();
        recursiveCombinations(digits, "", combinations);
        return combinations;
    }

    private void recursiveCombinations(String digits, String combination, List<String> combinations) {
        if (digits.length() == 0) { // base case
            combinations.add(combination);
            return;
        }
        char d = digits.charAt(0);
        if (d >= '2' && d <= '9') { // check digit is valid
            String letters = keyboard.get(d);
            for (int i = 0; i < letters.length(); i++) {
                recursiveCombinations(digits.substring(1), combination + letters.charAt(i), combinations);
            }
        }
    }
}
