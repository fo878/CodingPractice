package com.leetcode.calculation;

import java.util.*;

/*
* 989. 数组形式的整数加法
* */
public class addToArrayFormSolution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0,0,1,2};
        int K = 34;
//        int[] A = new int[]{9,9,9,9,9,9,9,9,9,9};
//        int K = 1;
        addToArrayFormSolution foo = new addToArrayFormSolution();
        System.out.println(foo.addToArrayForm(A,K));
    }
}
