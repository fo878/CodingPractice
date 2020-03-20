package com.leetcode.calculation;

import java.util.Arrays;

/*
*  把数字翻译成字符串
*
* 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25
* 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
* 示例
* 输入: 12258
* 输出: 5
* 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
*
* 分析：
*       一位数字    f(1) = 1
*       如果两位数字小于等于26，那么这两位有两种不同的翻译方法，
*       如果两位数字大于26，那么这两位只有一种翻译方法 f(2) = f(1) + 1*(最后两位数字小于等于26)
*
*       如果数字为三位，方法数为f(3) = f(2) + 1*(最后两位数字小于等于26)
*       如果数字为四位，方法数为f(4) = f(3) + 1*(最后两位数字小于等于26)
*
* */
public class translateNumSolution {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 0; i < len; ++i) {
            dp[i + 1] += dp[i];
            if (i > 0) {
                if (str.charAt(i - 1) != '0' && str.substring(i - 1, i + 1).compareTo("25") <= 0)
                    dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }

    /*--------------递归---------------------*/
    private int len;
    private String str;

    public int translateNum1(int num) {
        str = String.valueOf(num);
        len = str.length();
        return dfs(0);
    }

    private int dfs(int begin) {
        if (begin == len)
            return 1;

        int sum = dfs(begin + 1);
        if (begin + 1 < len && str.charAt(begin) != '0') {
            if (str.substring(begin, begin + 2).compareTo("25") <= 0)
                sum += dfs(begin + 2);
        }
        return sum;
    }
    public static void main(String[] args) {
//        int num = 12258;
        int num1 = 18822;
        //1,8,8,2,2    18,8,2,2
        //1,8,8,22     18,8,22
        translateNumSolution foo = new translateNumSolution();
//        System.out.println(foo.translateNum(num));
        System.out.println(foo.translateNum(num1));
    }
}
