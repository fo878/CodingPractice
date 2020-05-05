package com.leetcode.DP;
/*
* 面试题 08.11. 硬币
* 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
* f(i,v)=f(i−1,v)+f(i,v−ci)
* class Solution {
private:
    static constexpr int mod = 1000000007;
    static constexpr int coins[4] = {25, 10, 5, 1};

public:
    int waysToChange(int n) {
        vector<int> f(n + 1);
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % mod;
            }
        }
        return f[n];
    }
};

* */
public class waysToChangeSolution {

    public static int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = new int[]{25, 10, 5, 1};

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                dp[i] = (dp[i] + dp[i-coin]) % mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(waysToChange(n));
    }
}
