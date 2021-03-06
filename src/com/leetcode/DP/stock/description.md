## 121. 买卖股票的最佳时机
描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。  
注意：你不能在买入股票前卖出股票。  
输入: [7,1,5,3,6,4]  
输出: 5  
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。  


## 122. 买卖股票的最佳时机 II
描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。  
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
输入: [7,1,5,3,6,4]  
输出: 7  
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
`    public static int maxProfit2(int[] prices) {
         int n = prices.length;
         if (n<=1) return 0;
         int[] dp = new int[n];
         dp[0] = 0;
         for (int i = 1; i < n; i++) {//状态转移方程，如果最后一天比倒数第二天多卖出去了，就更新
             dp[i] = Math.max(dp[i-1],dp[i-1] + prices[i] - prices[i-1]);
         }
         return dp[n-1];
     }
`  

## 123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。  
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。  
输入: [3,3,5,0,0,3,1,4]  
输出: 6  
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。  

## 188. 买卖股票的最佳时机 IV
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。-
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
输入: [2,4,1], k = 2  
输出: 2  
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。  

输入: [3,2,6,5,0,3], k = 2  
输出: 7  
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。  

## 714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2  
输出: 8  
解释: 能够达到的最大利润:  
在此处买入 prices[0] = 1  
在此处卖出 prices[3] = 8  
在此处买入 prices[4] = 4  
在此处卖出 prices[5] = 9  
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.  

## 309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

输入: [1,2,3,0,2]  
输出: 3   
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]  

## 901. 股票价格跨度
编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

输入：["StockSpanner","next","next","next","next","next","next","next"],   
[[],[100],[80],[60],[70],[60],[75],[85]]  
输出：[null,1,1,1,2,1,4,6]  
解释：  
首先，初始化 S = StockSpanner()，  
然后：
    S.next(100) 被调用并返回 1，  
    S.next(80) 被调用并返回 1，  
    S.next(60) 被调用并返回 1，  
    S.next(70) 被调用并返回 2，  
    S.next(60) 被调用并返回 1，  
    S.next(75) 被调用并返回 4，  
    S.next(85) 被调用并返回 6。  
注意： (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
(包括今天的价格 75) 小于或等于今天的价格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。