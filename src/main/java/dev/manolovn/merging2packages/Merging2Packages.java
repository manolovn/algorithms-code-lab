package dev.manolovn.merging2packages;

import java.util.HashMap;
import java.util.Map;

public class Merging2Packages {

    public int[] getIndicesOfItemWeights(int[] arr, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < arr.length; i++ ) {
            if (map.containsKey(arr[i])) {
                return new int[]{ i, map.get(arr[i]) };
            }
            int diff = limit - arr[i];
            map.put(diff, i);
        }
        return new int[]{};
    }
}
