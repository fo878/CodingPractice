package com.nowcoder.tiger1;

public class test {
    public static void main(String[] args) {
        int n= 3;
        System.out.println(calculate(n));
    }
    private static int calculate(int n){
        if(n<=2){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2 ; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
