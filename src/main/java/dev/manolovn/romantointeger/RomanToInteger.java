package dev.manolovn.romantointeger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int val = dict.get(s.charAt(i));
            if (n > i + 1 && dict.containsKey(s.charAt(i + 1))
                    && dict.get(s.charAt(i + 1)) > val) {
                ans += dict.get(s.charAt(i + 1)) - val;
                i++;
            } else {
                ans += val;
            }
        }
        return ans;
    }
}
