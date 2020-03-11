package com.leetcode.calculation;

import java.util.Arrays;

/*
* 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
* 如果没有任何一种硬币组合能组成总金额，返回 -1。

    输入: coins = [1, 2, 5], amount = 11
    输出: 3
    解释: 11 = 5 + 5 + 1
    *
分析：
*   本来想着最少的硬币个数就尽量用小于amount的最大硬币来支付，直到最后总金额为0，输出支付硬币的个数
*   错误的地方在于，每次都使用小于amount的最大硬币，并不能保证到最后都能按整数找开。
     public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        int n = coins.length;
        int i = 0;
        int maxless=0;
        while (amount>0){
            //coins中小于等于amount的最大值
            maxless = help(coins,amount);
            if (maxless == -1){
                return maxless;
            }else if (maxless == amount){
                return i+1;
            }else {
                amount -= maxless;
                i++;
            }
        }
        return -1;
    }

    public int help(int[] coins,int amount){
        for (int j = coins.length-1; j >=0 ; j--) {
            if (coins[j]<=amount){
                return coins[j];
            }
        }
        return -1;
    }
*
* 动态规划：
*
* */
public class coinChangeSolution {
    /*------官方题解-----------------*/
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

/*
* F(i) =（j=0…n−1）min F(i−cj）+ 1
定义 F(i) 为组成金额 i 所需最少的硬币数量
* */
    public int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins1 = {186,419,83,408};
        int amount1 = 6249;
//        int[] coins2 = {1};
//        int amount2 = 0;
        coinChangeSolution foo = new coinChangeSolution();
        System.out.println(foo.coinChange(coins1,amount1));//20
//        System.out.println(foo.coinChange(coins2,amount2));
    }
}
