package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
* */
public class sumZeroSolution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < res.length-1; i++) {
            res[i] = (int)(Math.random()*100)-50;
            sum += res[i];
        }
        res[n-1] = -sum;
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        sumZeroSolution foo = new sumZeroSolution();
        System.out.println(Arrays.toString(foo.sumZero(5)));
    }
}
