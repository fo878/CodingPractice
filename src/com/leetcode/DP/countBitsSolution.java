package com.leetcode.DP;

import java.util.Arrays;

import static java.lang.Math.log;

/*
* countBits  338. 比特位计数
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
* */
public class countBitsSolution {
    public static int[] countBits(int num) {
        if (num==0){
            return new int[]{};
        }
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        if (num==1){
            return dp;
        }
        for (int n = 2; n <= num; n++) {
            int m = n-(int)(Math.pow(2.0,(int) Math.floor(log(n)/log(2))));
            dp[n] = 1 + dp[m];
        }
        return dp;
    }

    public static void main(String[] args) {
        int num = 0;
        int[] out = countBits(num);
        System.out.println(Arrays.toString(out));
    }
}
