package com.leetcode.DataStructure.Hash;

import java.util.ArrayList;
import java.util.HashSet;
/*
* 给定两个数组，编写一个函数来计算它们的交集。
* */
class IntersectionSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        HashSet<Integer> set2 = new HashSet<>(nums2.length);
        for (int i : nums1) {
            set1.add(i);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        for (Integer e : set1) {
            if (set2.contains(e)){
                list.add(e);
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer x : list) {
            res[i] = (int)x;
            i++;
        }
        return res;
    }
}