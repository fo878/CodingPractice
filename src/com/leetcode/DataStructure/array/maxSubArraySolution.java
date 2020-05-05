package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
*53. 最大子序和
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * */
public class maxSubArraySolution {
    public static int maxSubArray(int[] nums){
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num,num);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
