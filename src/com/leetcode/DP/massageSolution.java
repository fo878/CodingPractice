package com.leetcode.DP;
/*
按摩师
* 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
* 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
* 替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数
* */

public class massageSolution {
    public int massage(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{0};
        massageSolution foo = new massageSolution();
        System.out.println(foo.massage(a));
    }
}
