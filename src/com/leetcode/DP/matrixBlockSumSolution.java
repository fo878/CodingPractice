package com.leetcode.DP;

import java.util.Arrays;

/*
* 给你一个 m * n 的矩阵 mat 和一个整数 K ，
* 请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
* i - K <= r <= i + K, j - K <= c <= j + K 
* (r, c) 在矩阵内。
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matrix-block-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class matrixBlockSumSolution {
    public static int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        if (m==0) return new int[][]{{}};
        if (m==1) return mat;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        /*
        * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
        * 输出：[[12,21,16],[27,45,33],[24,39,28]]
        * */
        int[][] mat = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int K = 1;
        int[][] out = matrixBlockSum(mat, K);
        for (int i = 0; i < out.length; i++) {
            System.out.println(Arrays.toString(out[i]));

        }
    }
}
