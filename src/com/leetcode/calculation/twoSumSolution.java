package com.leetcode.calculation;
/*
*  n个骰子的点数  （未完成）
* 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
*
* 1 <= n <= 11
* */
public class twoSumSolution {
    public double[] twoSum(int n) {
        int [][]dp = new int[n+1][6*n+1];
        //边界条件
        for(int s=1;s<=6;s++)dp[1][s]=1;
        for(int i=2;i<=n;i++){
            for(int s=i;s<=6*i;s++){
                //求dp[i][s]
                for(int d=1;d<=6;d++){
                    if(s-d<i-1)break;//为0了
                    dp[i][s]+=dp[i-1][s-d];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;
        }
        return ans;
    }
}
