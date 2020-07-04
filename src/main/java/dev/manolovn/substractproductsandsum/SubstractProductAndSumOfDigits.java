package dev.manolovn.substractproductsandsum;

/**
 * source: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * difficulty: EASY
 */
public class SubstractProductAndSumOfDigits {

    /*
    Time:  O(n) ; where n is the number of digits of input
    Space: O(1) ; no extra data structures needed
    */
    public int subtractProductAndSum(int n) {
        int products = digitProducts(n);
        int sum = digitSum(n);
        return products - sum;
    }

    private int digitProducts(int n) {
        int result = 1;
        while (n != 0) {
            result *= n % 10;
            n /= 10;
        }
        return result;
    }

    private int digitSum(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
