package com.leetcode.DP;
/*
* 416. 分割等和子集
* 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
* */
public class canPartitionSolution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n<2){
            return false;
        }

        int sum = 0, max = Integer.MIN_VALUE, target;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
        }
        if (sum%2 != 0){
            return false;
        }
        target = sum/2;
        if (target < max){
            return false;
        }
        /*
        * dp[i][j]表示从数组[0,i]下标范围内选取若干个(大于等于0个)正整数，
        * 是否存在一种选取方案，使得被选取的正整数的和等于j
        * */
        boolean[][] dp = new boolean[n][target+1];//n>=2
        //边界情况1，不选取任何正整数，j==0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //边界情况2，i==0,只有nums[0]能被选取，所以只有dp[0][nums[0]]=true
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j>=num){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        canPartitionSolution foo = new canPartitionSolution();
        System.out.println(foo.canPartition(nums1));
        System.out.println(foo.canPartition(nums2));
    }
}
