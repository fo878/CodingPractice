package com.leetcode.DataStructure.array;
/*
*
* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


* */
/*
* 判断i与j是否越界，如果越界则返回false
   否则执行：
       判断当前数字与目标数字是否相等
           如果相等，则返回true
           如果不等，判断当前数字是否比目标数字大
               如果比目标数字大，i--
               否则，如果比目标数字小，j++
* */
public class findNumberIn2DArraySolution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while (i>=0 && j<matrix[0].length){
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] M ={
          {1,   4,  7, 11, 15},
          {2,   5,  8, 12, 19},
          {3,   6,  9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}
        };
        findNumberIn2DArraySolution foo = new findNumberIn2DArraySolution();
        System.out.println(foo.findNumberIn2DArray(M,5));
        System.out.println(foo.findNumberIn2DArray(M,20));
    }
}
