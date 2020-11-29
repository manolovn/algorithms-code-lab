package dev.manolovn.bulbswitcher;

/**
 * source: https://leetcode.com/problems/bulb-switcher/
 * difficulty: MEDIUM
 * topic: MATH
 */
public class BulbSwitcher {

    /*
    2^2 2^1 2^0
    0   0   0 = 0
    1   1   1 = 6
    1   0   1 = 5
    1   0   0 = 4

    0   0   0
    0   0   1 = 1

    factor of 6: 1,2,3,6
    factor of 7: 1,7
    factor of 9: 1,3,9

    so all number have even number of factors except square number(e.g: factor of 9:1,3,9).
    square number must turn on because of odd number of factors(9: turn on at 1st, off at 3rd, on at 9th)
    other number must turn off(6: turn on at 1st, off at 2nd, on at 3rd, off at 6th)
    so we only need to compute the number of square number less equal than n
    */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
