package dev.manolovn.longpressedname;

/**
 * source: https://leetcode.com/problems/long-pressed-name/
 * difficulty: EASY
 */
public class LongPressedName {

    /*
    [Approach]
    The main idea is a two pointers approach with the following strategy:
        - traverse typed input keeping a pointer to name input
        - if characters are equals, continue iterating typed and name
        - if character in typed is equal to previous character in name, continue iterating typed
        - in other cases return false
        After traversing typed, the pointer on name input should be equals to name length
    [Complexity]
    Time:  O(N+T) ; where N and T are the lengths of name and typed inputs
    Space: O(1) ; constant space; no extra data structures are needed
    */
    public boolean isLongPressedName(String name, String typed) {
        // precondition: if typed is shorter than name, is always false
        if (typed.length() < name.length()) return false;
        // special case: when name and typed are with the same length, compare them
        if (typed.length() == name.length()) return typed.equals(name);

        int ni = 0;
        for (int i = 0 ; i < typed.length() ; i++) {
            if (ni < name.length() && typed.charAt(i) == name.charAt(ni)) {
                ni++;
                continue;
            }
            if (i > 0 && typed.charAt(i) == typed.charAt(i-1)) {
                continue;
            }
            return false;
        }
        return ni == name.length();
    }
}
