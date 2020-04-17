package dev.manolovn.palindromenumber;

public class PalindromeNumber {

    static boolean isPalindrome(int x) {
        // negative numbers never could be palindrome
        // number finishing in 0 that it's not 0 itself
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
