package com.leetcode.DataStructure.array;

import java.util.*;

/*
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。

 
*/
public class smallerNumbersThanCurrentSolution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        int[] sortnums = nums.clone();
        Arrays.sort(sortnums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortnums[i],i);
        }
        for (int i = 0; i < n; i++) {
            out[i] = map.get(nums[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sortnums));
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        smallerNumbersThanCurrentSolution foo = new smallerNumbersThanCurrentSolution();
        int[] out = foo.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(out));//4,0,1,1,3
    }
}
