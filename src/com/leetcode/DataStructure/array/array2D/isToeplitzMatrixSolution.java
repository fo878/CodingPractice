package com.leetcode.DataStructure.array.array2D;
/*
* 766. 托普利茨矩阵
给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

* m * n矩阵有多少对角线 ？ m+n-1个对角线
* 当且仅当矩阵中每个元素都与其左上角相邻的元素（如果存在）相等时，该矩阵为托普利茨矩阵
 * */
class isToeplitzMatrixSolution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i>0 && j>0) {
                    if (matrix[i][j] != matrix[i-1][j-1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}