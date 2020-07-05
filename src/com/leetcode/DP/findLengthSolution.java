package com.leetcode.DP;
/*
* 718. 最长重复子数组
* 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
*
* */
class findLengthSolution {
    public static int findLength(int[] A, int[] B) {
        //动态规划
        int m = A.length;
        int n = B.length;
        int dp[][] = new int[m+1][n+1];
        int ans = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                if (A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 6, 1, 2, 4};
        int[] B = {7, 1, 2, 9};
        System.out.println(findLength(A,B));
    }
}