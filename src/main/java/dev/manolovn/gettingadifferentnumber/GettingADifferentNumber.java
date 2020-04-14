package dev.manolovn.gettingadifferentnumber;

public class GettingADifferentNumber {

    /*
      0. validate the input

      #1 [0, 1, 2, 3] output : 4
      #2 [0, 3, 4, 9] output : 1

      #1 boolean[] [true, true, true, true] : boolean.length + 1
      #2 boolean[] [true, false] :

      1. populate a map
      [0, 1, 2, 3]
          ^
      2.

      [2, 1]

      time : O(n)
      space: O(n)

      --> alternative with arr modification
      space: O(1)
    */
    static int getDifferentNumber(int[] arr) {
        if (!validateInput(arr)) {
            return 0;
        }

        boolean[] gaps = new boolean[arr.length]; // TODO: try with a bit mask
        for (int value : arr) {
            if (value < gaps.length) {
                gaps[value] = true;
            }
        }

        for (int i = 0; i < gaps.length; i++) {
            if (!gaps[i]) {
                return i;
            }
        }

        return gaps.length;
    }

    static boolean validateInput(int[] arr) {
        return arr != null && arr.length >= 1;
    }
}
