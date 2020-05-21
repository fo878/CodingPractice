package com.leetcode.DP;
/*
* 152. 乘积最大子数组
* 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
* */
public class maxProductSolution {
    public int maxProduct(int[] nums){
        int max = nums[0];
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],minF[i-1]*nums[i]));
            minF[i] = Math.min(minF[i-1]*nums[i],Math.min(nums[i],maxF[i-1]*nums[i]));
            max = Math.max(maxF[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        maxProductSolution foo = new maxProductSolution();
        System.out.println(foo.maxProduct(nums));
    }
}
