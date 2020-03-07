package com.leetcode.calculation;
/*
*  n个骰子的点数  （未完成）
* 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

* P 1/6
* 2  3  4  5  6  7  8  9  10  11  12
*
* {1,1,1,1,1,1}
* {1,2,3,4,5,6,5,4,3,2,1}
* {,}
* */
public class twoSumSolution {
    public double[] twoSum(int n) {
        int m = 5*n+1;//n个骰子之和有m种可能性
        double[] P = new double[m];
        return P;
    }

//    public int[] help(int n){
//        //设置辅助函数，用来递归计算n个骰子时，输出一个数组
//
//    }
}
