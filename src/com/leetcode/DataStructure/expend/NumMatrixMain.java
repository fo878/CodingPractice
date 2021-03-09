package com.leetcode.DataStructure.expend;

import java.util.Arrays;

class NumMatrix {

    int[][] sums;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        if (m>0){
            int n = matrix[0].length;
            sums = new int[m+1][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }


    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}

public class NumMatrixMain {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        NumMatrix obj = new NumMatrix(matrix);
//        int param_1 = obj.sumRegion(1,1,2,2);//45 - 6 - 12 + 1 = 28
//        int param_2 = obj.sumRegion(0,0,2,2);//45
        int param_3 = obj.sumRegion(0,1,1,2);//16
//        System.out.println(param_1);
//        System.out.println(param_2);
        System.out.println(param_3);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */