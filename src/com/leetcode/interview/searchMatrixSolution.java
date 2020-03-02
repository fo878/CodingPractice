package com.leetcode.interview;

import java.util.Collection;
import java.util.Collections;

/*
*编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。
* */
public class searchMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //暴力求解
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}  
        };
        int target = 9;
        searchMatrixSolution foo = new searchMatrixSolution();
        System.out.println("是否能找到目标元素： "+ foo.searchMatrix(matrix,target));
    }
}
