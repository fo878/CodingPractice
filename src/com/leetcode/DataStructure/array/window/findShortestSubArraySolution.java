package com.leetcode.DataStructure.array.window;

import java.util.HashMap;

/*
* 697. 数组的度
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
* */
class findShortestSubArraySolution {
    public static int findShortestSubArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(); //使用map来保存当前子数组

        // 滑动窗口找到最短连续子数组
        int left = 0;
        int shortestLen = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {

        }

        return shortestLen;//先返回数组的度
    }

    public static int getDegree(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            max = Math.max(max,map.get(nums[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }
}