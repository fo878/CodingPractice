package com.leetcode.DP;
/*
* 5. 最长回文子串
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
* */
public class longestPalindromeSolution {
    //动态规划 状态dp[i][j]表示子串s[i..j]是否为回文子串
    /*状态转移方程
        dp[i][j] = (s[i]==s[j]) && dp[i+1][j-1]

      边界条件： j-i+1<4 时，不用检查是否是回文串
      初始化 对角线值 dp[i][i] = true
      输出： 记录起始位置和回文长度
    */
    public String longestPalindrome(String s){
        int len = s.length();
        if (len<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];//状态dp[i][j]表示子串s[i..j]是否为回文子串
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        //先填左下角
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //只要dp[i][j] == true成立就表示s[i..j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        longestPalindromeSolution foo = new longestPalindromeSolution();
        System.out.println(foo.longestPalindrome(s));
    }
}
