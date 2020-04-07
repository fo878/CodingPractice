package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 旋转矩阵：
* 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
* 不占用额外内存空间能否做到？
* */
public class rotateSolution {
    public static void rotate(int[][] matrix){
        int m = matrix.length;
        if (m==0){
            return;
        }
        int n = matrix[0].length;
        int[][] M = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M[j][m-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                matrix[i][j] = M[i][j];
            }
        }
    }

    public static void rotate1(int[][] matrix){
        int m = matrix.length;
        int n = matrix.length;
        if (m==0) return;
        //行倒序
        for (int i = 0; i < m/2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[m-i-1];
            matrix[m-i-1] = tmp;
        }
        //转置
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
