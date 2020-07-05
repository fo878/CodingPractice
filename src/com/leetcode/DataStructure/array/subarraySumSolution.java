package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
* 560. 和为K的子数组
* 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
*
* */
public class subarraySumSolution {
    public int subarraySum(int[] nums, int k){
        //key为前缀和，value为前缀和对应的个数
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum-k)){
                count += map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k = 2;
        subarraySumSolution foo = new subarraySumSolution();
        System.out.println(foo.subarraySum(nums,k));
    }
}
