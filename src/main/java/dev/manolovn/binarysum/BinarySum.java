package dev.manolovn.binarysum;

public class BinarySum {

    /**
     * The solution is easily extensible to sum other string numbers
     * just changing the BASE constant
     * in this exercise is 2 because we are working with binary numbers
     */
    private static final int BASE = 2;

    static String binarySum(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;

        while (i >= 0 || j >= 0 || sum == 1) {
            // char - '0' is a quick trick to cast a char into int
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;

            // important not to concatenate with '+' inside a loop
            // you should use StringBuilder or StringBuffer
            sb.insert(0, (char) (sum % BASE + '0'));

            sum /= BASE;
            i--;
            j--;
        }

        return sb.toString();
    }

    /**
     * This solution is not valid because the intention of this problem
     * is not to use binary operators.
     * <p>
     * As interviewee you should ask if this kind of solution is allowed
     * before coding
     */
    static String invalidSolve(String a, String b) {
        int ai = Integer.parseInt(a);
        int bi = Integer.parseInt(b);

        while (bi != 0) {
            int c = ai & bi;
            ai = ai ^ bi;
            bi = c << 1;
        }

        return Integer.toString(ai);
    }
}
