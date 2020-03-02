package com.leetcode.DataStructure.Hash;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* */
class SingleNumberSolution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)){
                set.remove(x);
            }else {
                set.add(x);
            }
        }
        Object[] res = set.toArray();
        return (int)res[0];
    }
}