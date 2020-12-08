package com.leetcode.greedy;
//861. 翻转矩阵后的得分

import java.util.Arrays;

/*
* 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。
* */
public class matrixScoreSolution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            //翻转行，让第一列的数字变为1
            if (A[i][0]==0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = A[i][j] == 0? 1 : 0;
                }
            }
        }
        int n = A[0].length;
        int score = (int)Math.pow(2,n-1)*A.length;
        for (int j = 1; j < A[0].length; j++) {
            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
            }
            if (count1 >= count0) {
                //1多，该列不需要翻转，每个1贡献得分2^j-1
                score += (int)count1*(Math.pow(2,n-j-1));
            } else {
                score += (int)count0*(Math.pow(2,n-j-1));
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0},
        };
        matrixScoreSolution foo = new matrixScoreSolution();
        System.out.println(foo.matrixScore(A));
    }
}
