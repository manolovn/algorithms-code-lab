package dev.manolovn.relativesortarray;

import java.util.Arrays;

/**
 * source: https://leetcode.com/problems/relative-sort-array/
 * difficulty: EASY
 * topic: ARRAY + SORTING
 */
public class RelativeSortArray {

    /*
    1# brute force:
    for e2 : arr2
        search e2 in arr1 >> output // for loop
        delete e2 from arr1
    output + sort(arr1)
    ----
    time:  O(n*m) + O(nlogn) ; n and m are lenghts of arr1 and arr2
    space: O(n) ; n = len(arr1)

    2# hash map:
    map<int, int> -> key = value; value = freq
    for e1 : arr1
        create freq map
    for e2 : arr2
        for map(e2) in range(0, freq)
            map(e2) >> e1
            value(map(e2)--) // freq in map decrease
    sort(map keys where value > 0) >> e1
    ----
    time:  O(n) + O(m*n) + O(nlogn)
    space: O(n)
    */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequencyArr = new int[1001];
        int[] result = new int[arr1.length];

        //calculating the frequency of every element in arr1
        for (int e:arr1) {
            frequencyArr[e]++;
        }
        //declaring the counter as j
        int j = 0;

        //storing the value into result array according to arr2
        for (int e:arr2) {
            while (frequencyArr[e] > 0) {
                result[j++] = e;
                frequencyArr[e]--;
            }
        }

        //storing the remaining element
        for (int i = 0; i < frequencyArr.length; i++){
            while (frequencyArr[i] > 0) {
                result[j++] = i;
                frequencyArr[i]--;
            }
        }
        return result;
    }

    public int[] relativeSortArray_alternative(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int oi = 0; //output pointer
        int[] output = new int[n];
        for (int k : arr2) {
            for (int j = 0; j < n; j++) {
                if (arr1[j] == k) {
                    output[oi] = arr1[j];
                    arr1[j] = -1; // invalidate element
                    oi++;
                }
            }
        }
        Arrays.sort(arr1); // sort the elements
        for (int i = oi; i < n; i++) {
            output[oi] = arr1[i];
            oi++;
        }
        return output;
    }
}
