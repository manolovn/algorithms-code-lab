package dev.manolovn.multiplystrings;

/**
 * source: https://leetcode.com/problems/multiply-strings/
 * difficulty: MEDIUM
 * topic: ARRAYS + STRINGS + MATH
 */
public class MultiplyStrings {

    /*
         123 x
         456
    --------
       56088 -->
    res[ 0 0 0 0 1 8 ]
               l r

    time:  O(n * m)
    space: O(n + m)
    */
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int ld = i + j;
                int rd = i + j + 1;
                int sum = mult + res[rd];

                res[ld] += sum / 10;
                res[rd] = sum % 10;
            }
        }
        // convert from int array to String
        StringBuilder sb = new StringBuilder();
        for (int d : res) {
            if (!(sb.length() == 0 && d == 0)) { // to skip zeroes at beginning of res
                sb.append(d);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
