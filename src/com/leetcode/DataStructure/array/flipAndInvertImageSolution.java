package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

*/
public class flipAndInvertImageSolution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                tmp = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = tmp;
            }
            for (int j = 0; j < n; j++) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
//        int[][]A = {
//                {1,1,0,0},
//                {1,0,0,1},
//                {0,1,1,1},
//                {1,0,1,0}
//        };
        int[][]A = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        flipAndInvertImageSolution foo = new flipAndInvertImageSolution();
        int[][] M = foo.flipAndInvertImage(A);
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }
    }
}
