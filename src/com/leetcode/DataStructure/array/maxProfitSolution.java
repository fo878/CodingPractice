package com.leetcode.DataStructure.array;
/*
* 买卖股票的最佳时机
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
* 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
* 注意你不能在买入股票前卖出股票。
*
* 输入: [7,1,5,3,6,4]
* 输出: 5
* 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
*     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class maxProfitSolution {
    public int maxProfit1(int[] prices) {
        //效率低，时间复杂度O（n²）
        if (prices.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                cur = prices[j]-prices[i];
                if (cur>max){
                    max = cur;
                }
            }
        }
        return max;
    }

    public int maxProfit(int[] prices){
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

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        maxProfitSolution foo = new maxProfitSolution();
        System.out.println(foo.maxProfit1(prices));
    }

}
