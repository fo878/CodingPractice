package com.leetcode.DataStructure.cell;

import java.util.Arrays;

public class oddCellsSolution {
    public int oddCells(int n, int m, int[][] indices) {
        int num = 0;//用于记录最终矩阵的奇数个数
        int[][] source = new int[n][m];
        for (int i = 0; i < source.length;i++) {
            Arrays.fill(source[i],0);
//            System.out.println(Arrays.toString(source[i]));
        }
        int[] row = new int[indices.length];//行数和列数=indices的行数
        int[] col = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            row[i] = indices[i][0];
            col[i] = indices[i][1];
        }
//        System.out.println(Arrays.toString(row));
//        System.out.println(Arrays.toString(col));
        //对应行+1
        for (int i : row) {
            for (int j = 0; j < source[i].length; j++) {
                source[i][j]++;
            }
        }
        //对应列+1
        for (int j : col) {
            for (int i = 0; i < source.length; i++) {
                source[i][j]++;
            }
        }
        //打印变换后的矩阵
//        for (int i = 0; i < source.length;i++) {
//            System.out.println(Arrays.toString(source[i]));
//        }
        //统计奇数的个数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (source[i][j]%2==1){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        oddCellsSolution foo = new oddCellsSolution();
        int[][] indices = {
                {40,5}
        };
        int i = foo.oddCells(48, 37, indices);
        System.out.println("最后得结果，变换后矩阵的奇数个数为"+i);
    }
}
