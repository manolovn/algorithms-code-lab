package dev.manolovn.read4;

/**
 * source: https://leetcode.com/problems/read-n-characters-given-read4/
 * difficulty: EASY
 * topic: ARRAYS
 */
public class Read4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int writes = 0;
        int reads = 4;
        char[] buf4 = new char[4];

        while (writes < n && reads == 4) {
            reads = read4(buf4);
            for (int i = 0; i < reads; i++) {
                if (writes == n) {
                    return writes;
                }
                buf[writes] = buf4[i];
                writes++;
            }
        }
        return writes;
    }

    /**
     * dummy implementation, correct one is present in leetcode
     */
    int read4(char[] buf4) {
        return 4;
    }
}
