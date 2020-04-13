package dev.manolovn.kmessedarraysort;

import java.util.PriorityQueue;
import java.util.Queue;

public class KMessedArraySort {

    static int[] sortKMessedArray(int[] arr, int k) {
        int n = arr.length;
        Queue<Integer> q = new PriorityQueue<>();

        // build the min-heap from 0..k+1
        for (int i = 0; i <= k; i++) {
            q.add(arr[i]);
        }

        // extract top element and push it to next index
        for (int i = k + 1; i < arr.length; i++) {
            arr[i - (k + 1)] = q.poll();
            q.add(arr[i]);
        }

        // extract remaining
        for (int i = 0; i <= k; i++) {
            arr[n - 1 - k + i] = q.poll();
        }

        return arr;
    }
}
