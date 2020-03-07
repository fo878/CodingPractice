package com.leetcode.calculation;
/*
* 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
* */
public class sumNumsSolution {
    public int sumNums1(int n) {
        return (1+n)*n/2;
    }


    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
