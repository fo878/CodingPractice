package com.offer.test;

/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*
* 分析
*   采用递归方法
*   f(n) = f(n-1) + 2;
*   f(0) = 0;
*   f(1) = 1;
*   f(2) = 2;
*   f(3) = f(2) + f(1)                 正常是3种
*   f(4) = f(3) + f(2)                 正常是5种
*   依然是斐波那契数列
*
* */

public class RectCover {
    public int RectCover(int n) {
        int[] a = new int[n+1];
        if (n<=3){
            a[n]=n;
            return a[n];
        }
        else {
            for (int i = 0; i <= n; i++) {
                if (i<=3){
                    a[i]=i;
                }
                if (i>3) {
                    a[i] = a[i - 1] + a[i - 2];
                }
            }
            return a[n];
        }
    }
}
