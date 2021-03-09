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

    //123. 买卖股票的最佳时机 III(最多两次买卖，限定交易次数)
    //sell[i][]
    public static int maxProfit3(int[] prices) {
        return maxProfit(2,prices);
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

    /*
    188. 买卖股票的最佳时机 IV
    给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    我们用 buy[i][j] 表示对于数组 prices[0..i] 中的价格而言，进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
    用 sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。

    buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j] - prices[i])
    sell[i][j] = Math.max(sell[i-1][j] ,buy[i-1][j-1] + prices[i])

    buy[0][1..k] sell[0][1..k] 如果只有一日的股价，不会进行交易，最小值
    buy[0][0]    表示第一天买了1只唯一的股票，buy[0][0] = -prices[0]
    sell[0][0]   表示第一天不做任何事 sell[0][0] = 0

    最优是 sell[n-1][0...k]数组的最大值
    * */
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k,n/2);
        if (k==0 || n==0) {
            return 0;
        }
        int[][] buy = new int[n][k+1];
        int[][] sell = new int[n][k+1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[0][i] = Integer.MIN_VALUE/2;
            sell[0][i] = Integer.MIN_VALUE/2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i-1][0],sell[i-1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i-1][j] ,buy[i-1][j-1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }


    /*
    * 714. 买卖股票的最佳时机含手续费
    *
    * 考虑到「不能同时参与多笔交易」，
    * 因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
    * dp[i][0] 表示第i天交易完手里没有股票的最大利润
    * dp[i][1] 表示第i天交易完手里有股票的最大利润
    *
    * dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - prices[i-1] - fee)
    * dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i])
    * dp[0][0] = 0
    * dp[0][1] = -prices[0]
    * return dp[n-1][0]
    * */
    public int maxProfit5(int[] prices, int fee) {
        int n = prices.length;
        if (n<=1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
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