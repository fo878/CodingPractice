package com.leetcode.DataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 题目：最长上升子序列
* 类型: 动态规划
* 描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
* 示例：
*   输入: [10,9,2,5,3,7,101,18]
    输出: 4
    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
* 分析：
*   dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
*   dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
 * */
public class lengthOfLISSolution {
    // Dynamic programming.
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,4};//经测试发现此时最长子序列为[2,5]，而不是[2,3,4]
        lengthOfLISSolution foo = new lengthOfLISSolution();
        System.out.println(foo.lengthOfLIS(nums));
    }
}
