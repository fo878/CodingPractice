package com.leetcode.DataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;

/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
* */
public class printNumbersSolution {
    public int[] printNumbers(int n) {
        //求出n位的最大数m
        int nums[] = new int[n];
        Arrays.fill(nums,9);
        StringBuffer sb = new StringBuffer();
        for (int num : nums) {
            sb.append(num);
        }
        //System.out.println(sb);
        int m = Integer.parseInt(sb.toString());
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        printNumbersSolution foo = new printNumbersSolution();
        int[] array = foo.printNumbers(n);
        System.out.println(Arrays.toString(array));
    }
}
