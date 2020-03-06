package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
* 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
* 不能使用除法。

    输入: [1,2,3,4,5]
    输出: [120,60,40,30,24]
    *
    * 1,1,2,6,24
    * 120,60,20,5,1
    * 120 60 40 30 24
    *
    * 1 n1 n1*n2 n1*n2*n3 n1*n2*n3*n4
    * n2*n3*n4*n5 n3*n4*n5 n4*n5 n5 1
    * n2*n3*n4*n5 n1*n3*n4*n5 n1*n2*n4*n5 n1*n2*n3*n5 n1*n2*n3*n4

*
* */
public class constructArrSolution {
    public int[] constructArr(int[] a) {
        int n =a.length;
        if (n==0){
            return new int[]{};
        }
        int[] b = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;R[n-1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i-1]*a[i-1];
            R[n-i-1] = R[n-i]*a[n-i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = L[i] * R [i];
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        constructArrSolution foo = new constructArrSolution();
        foo.constructArr(a);
    }
}
