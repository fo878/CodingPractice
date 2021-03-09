package com.leetcode.DataStructure.array.window;


/*
* 643. 子数组最大平均数 I
* 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * */
class findMaxAverageSolution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = (double)(sum) / k;
        for (int i = 0,j = k; j < n;i++, j++) {
            sum += nums[j] - nums[i];
            ans = Math.max(ans,(double)(sum) / k);
        }
        return ans;
    }
}