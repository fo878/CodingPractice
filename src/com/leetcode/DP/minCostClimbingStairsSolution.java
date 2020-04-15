package com.leetcode.DP;

import java.util.Arrays;

/*
* 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost1[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
示例 1:
输入: cost1 = [10, 15, 20]
输出: 15
最低花费是从cost1[1]开始，然后走两步即可到阶梯顶，一共花费15。
示例 2:
输入: cost1 = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost1[0]开始，逐个经过那些1，跳过cost1[3]，一共花费6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost1-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class minCostClimbingStairsSolution {
    public static int minCostClimbingStairs(int[] cost) {
        int[] cost1 = new int[cost.length+1];
        for (int i = 0; i < cost.length; i++) {
            cost1[i] = cost[i];
        }
        cost1[cost.length] = 0;
        if (cost1.length<=1)return 0;
        int[] dp = new int[cost1.length];
        int res = Integer.MAX_VALUE;

        for (int k = 0; k < 2; k++) {//初始台阶为k
            if (k==0){
                dp[0] = cost1[0];
                dp[1] = cost1[1];
            }else {
                dp[1] = cost1[1];
                dp[2] = cost1[2];
            }
            for (int i = 2+k; i < dp.length; i++) {
                dp[i] += Math.min(dp[i-2] + cost1[i],dp[i-1] + cost1[i]);
            }
            res = Math.min(res,dp[cost1.length-1]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //int[] cost = new int[]{10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
