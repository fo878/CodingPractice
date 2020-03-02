package com.offer.test;
/*
*
* 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
请你统计并返回 grid 中 负数 的数目
* */
public class countNegativesSolution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]<0){
                    res++;
                }
            }
        }
        return res;
    }
}
