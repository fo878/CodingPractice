package com.leetcode.DP.stock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    //121. 买卖股票的最佳时机
    public int maxProfit1(int[] prices){
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min = prices[i];
            }
            if (prices[i] - min> maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    //122. 买卖股票的最佳时机 II(多次买卖)
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n<=1) return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-1] + prices[i] - prices[i-1]);
        }
        return dp[n-1];
    }

    //122. 买卖股票的最佳时机 II(最多两次买卖，限定交易次数)
    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n<=1) return 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min = prices[i];
            }
            if (prices[i] - min> maxProfit){
                maxProfit = prices[i] - min;//一次交易的最大值
            }
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i]-prices[i-1]>0){
                dp[i] = prices[i]-prices[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));

        int res = dp[n-1] + dp[n-2];
        return Math.max(res,maxProfit);
    }

    //309. 最佳买卖股票时机含冷冻期
    /*
    给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    * */
    public static int maxProfit4(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
//        int[][] dp = new int[n][3];
//        dp[0][0] = -prices[0];
//        for (int i = 1; i < n; ++i) {
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
//            dp[i][1] = dp[i-1][0] + prices[i];
//            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
//        }
//        return Math.max(dp[n-1][1],dp[n-1][2]);
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        int ndp0,ndp1,ndp2;
        for (int i = 1; i < n; i++) {
            ndp0 = Math.max(dp0,dp2-prices[i]);
            ndp1 = dp0 + prices[i];
            ndp2 = Math.max(dp1,dp2);
            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;
        }
        return Math.max(dp1,dp2);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices1 = new int[]{1,2,3,4,5};
        int[] prices2 = new int[]{3,3,5,0,0,3,1,4};
        int[] prices3 = new int[]{6,1,3,2,4,7};
        int[] prices4 = new int[]{1,2,3,0,2};
//        System.out.println(maxProfit2(prices));
//        System.out.println(maxProfit2(prices1));6
//        System.out.println(maxProfit3(prices2));//
//        System.out.println(maxProfit3(prices1));//4
//        System.out.println(maxProfit3(prices3));//7
        System.out.println(maxProfit4(prices4));//3
    }
}