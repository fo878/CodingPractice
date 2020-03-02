package com.leetcode.DataStructure.Hash;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class MyHashSet {
    /** Initialize your data structure here. */
    int [] data = null;
    public MyHashSet() {
        data = new int[1000001];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    public void add(int key) {
        data[key] = key;
    }

    public void remove(int key) {
        data[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] == -1? false : true;
    }
}