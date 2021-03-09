package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 888. 公平的糖果棒交换
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。
* */
class fairCandySwapSolution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int j = 0; j < B.length; j++) {
            sumB += B[j];
        }
        int target = (sumA-sumB) / 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == target) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,1};
        int[] B = new int[]{2,2};
        fairCandySwapSolution foo = new fairCandySwapSolution();
        System.out.println(Arrays.toString(foo.fairCandySwap(A,B)));
    }
}