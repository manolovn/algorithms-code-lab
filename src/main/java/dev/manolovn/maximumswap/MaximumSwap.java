package dev.manolovn.maximumswap;

/**
 * source: https://leetcode.com/problems/maximum-swap/
 * difficulty: MEDIUM
 * topic: ARRAY + MATH
 */
public class MaximumSwap {

    /*
    2736 -> 7236
    9973 -> 9973
    19 -> 91
    5346 -> 6345

    1. num -> string
    2. map of { digit : position }
    3. 2736
       ^ to every position lookup to another digit greater
         that is located to the right (map[7] > i)

    Time:  O(n)
    Space: O(n)
    */
    public int maximumSwap(int num) {
        char[] number = Integer.toString(num).toCharArray();
        int[] map = new int[10];
        for (int i = 0; i < number.length; i++) map[number[i] - '0'] = i;

        for (int i = 0; i < number.length; i++) {
            for (int d = 9; d > number[i] - '0'; d--) {
                if (map[d] > i) {
                    char tmp = number[i];
                    number[i] = number[map[d]];
                    number[map[d]] = tmp;
                    return Integer.parseInt(new String(number));
                }
            }
        }
        return num;
    }
}
