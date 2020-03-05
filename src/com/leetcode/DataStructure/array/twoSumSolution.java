package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
* 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
*
*   输入：nums = [2,7,11,15], target = 9
    输出：[2,7] 或者 [7,2]
* */
public class twoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target) right--;
            else if(sum < target) left++;
            else return new int[]{nums[left], nums[right]};
        }
        return new int[0];
    }
}
