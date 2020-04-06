package com.leetcode.DP;

import java.util.Arrays;

/*
* 打家劫舍 1
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
* 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警.
* 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class robSolution {
    public static int rob1(int[] nums) {
        int m = nums.length;
        if (m == 0) return 0;
        if (m == 1) return nums[0];
        int[] dp = new int[m];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < m; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[m-1];
    }

    /*
* 打家劫舍 2
* 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
* 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
* 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
* 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
    public static int rob2(int[] nums) {
        int m = nums.length;
        if (m == 0) return 0;
        if (m == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums,0,m-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,m);
        return Math.max(rob1(nums1),rob1((nums2)));
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,1};
        int[] a2 = new int[]{2,7,9,3,1};
//        System.out.println(rob1(a1));
//        System.out.println(rob1(a2));
        int[] a3 = new int[]{2,3,2};
        int[] a4 = new int[]{1,2,3,1};
        int[] a5 = new int[]{1,2,1,1};
//        System.out.println(rob2(a3));
//        System.out.println(rob2(a4));
        System.out.println(rob2(a5));
    }
}
