package dev.manolovn.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /*
    #1: Sorting approach
    Sort the input counting the value is up to the ceil (n/2)
    Time:  O(nlogn) + O(n) = O(nlogn)
    Space: O(1)
    #2: Map approach
    Time:  O(n)
    Space: O(n)
    */
    public int majorityElement(int[] nums) {
        int ceil = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int aux = map.get(num) + 1;
                if (aux > ceil) {
                    return num;
                }
                map.put(num, aux);
            } else {
                map.put(num, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
