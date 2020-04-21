package dev.manolovn.staircase;

public class Staircase {

    /*
        Very simple problem, just need to take attention to the limits of drawing

        Time: O(n^2) ;  only one pass is needed and two loops are executed
                        take into account that repeat function runs a loop, but not over all values n
                        one loop goes to [0..k] and the other one to [k..n] so the two loops in the two calls
                        to repeat function complete a full loop; so O(n) * O(n) of the main loop
        Space: O(1) ; we don't need additional data structures
     */
    static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            repeat(' ', n - 1 - i);
            repeat('#', i + 1);
            if ((i + 1) < n) { // false to the last line
                System.out.print("\n");
            }
        }
    }

    private static void repeat(char c, int times) {
        for (int k = 0; k < times; k++) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        staircase(Integer.MAX_VALUE);
    }
}
