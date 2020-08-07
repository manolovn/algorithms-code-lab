package dev.manolovn.designhashset;

import java.util.ArrayList;

/**
 * source: https://leetcode.com/problems/design-hashset
 * difficulty: EASY
 */
class MyHashSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        Integer it = key;
        list.remove(it);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/*
  Your MyHashSet object will be instantiated and called as such:
  MyHashSet obj = new MyHashSet();
  obj.add(key);
  obj.remove(key);
  boolean param_3 = obj.contains(key);
 */
