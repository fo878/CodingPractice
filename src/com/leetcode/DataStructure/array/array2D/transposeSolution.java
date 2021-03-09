package com.leetcode.DataStructure.array.array2D;

import java.util.Arrays;

/*
* 867. 转置矩阵
* 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
* */
class transposeSolution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix= new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        transposeSolution foo = new transposeSolution();
        foo.transpose(matrix);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}