package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
