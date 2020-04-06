package com.leetcode.DP;
/*
 编辑距离
 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
* */
public class minDistanceSolution {
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+2];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(
                            dp[i-1][j] + 1,
                            dp[i][j-1] + 1,
                            dp[i-1][j-1] + 1
                    );
                }
            }
        }
        return dp[l1][l2];
    }

    public static int min(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        String word3 = "intention";
        String word4 = "execution";
        System.out.println(minDistance(word1,word2));
        System.out.println(minDistance(word3,word4));
    }
}
