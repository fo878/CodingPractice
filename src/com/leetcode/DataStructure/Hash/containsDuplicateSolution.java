package com.leetcode.DataStructure.Hash;

import java.util.HashSet;
import java.util.Set;
/*
* 给定一个整数数组，判断是否存在重复元素。
* */
class containsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashset.add(nums[i]);
        }
        if (hashset.size() == nums.length){
            return false;
        }else {
            return true;
        }
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}