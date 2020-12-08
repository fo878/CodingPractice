package com.leetcode.DataStructure.array;

import java.util.HashMap;

class fourSumCountSolution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int u : A) {
            for (int v : B) {
                map1.put(u+v,map1.getOrDefault(u+v,0)+1);
            }
        }
        int count = 0;
        for (int u : C) {
            for (int v : D) {
                count += map1.get(-(u+v));
            }
        }
        return count;
    }
}