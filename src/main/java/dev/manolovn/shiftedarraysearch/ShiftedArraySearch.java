package dev.manolovn.shiftedarraysearch;

public class ShiftedArraySearch {

    /*
      [9, 12, 17, 0,1, 2, 4, 5,6,7,8], num = 0
      output = 3

      [9, 12, 17, 2, 4, 5], num = 5
                  ^
                  2 subsets


      [2, 4, 5, 9, 12, 17], num = 2
      output = 0

      1. find rotation point
      2. binary search -> O(log n)

      brute: time: O(n) [discarded]
      time: O(log n)
      space: O(1)
    */
    static int shiftedArrSearch(int[] shiftArr, int num) {
        int rotationPoint = findRotationPoint(shiftArr);

        if (rotationPoint == 0 || num < shiftArr[0]) {
            return binarySearch(shiftArr, rotationPoint, shiftArr.length - 1, num);
        }

        return binarySearch(shiftArr, 0, rotationPoint - 1, num);
    }

    private static int findRotationPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (mid == 0 || arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] arr, int low, int high, int num) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] == num) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
