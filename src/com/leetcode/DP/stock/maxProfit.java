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
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices1 = new int[]{1,2,3,4,5};
        int[] prices2 = new int[]{3,3,5,0,0,3,1,4};
        int[] prices3 = new int[]{6,1,3,2,4,7};
//        System.out.println(maxProfit2(prices));
//        System.out.println(maxProfit2(prices1));6
//        System.out.println(maxProfit3(prices2));//
//        System.out.println(maxProfit3(prices1));//4
        System.out.println(maxProfit3(prices3));//7
    }
}