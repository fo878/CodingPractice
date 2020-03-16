package com.leetcode.DataStructure.array;

import java.util.LinkedList;
import java.util.Queue;

/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？
* */
public class movingCountSolution {
    public int movingCount(int m, int n, int k) {
        int[][] M = new int[m][n];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (digitNumSum(i) + digitNumSum(j)>k){
                    M[i][j] = -1;
                }else {
                    M[i][j] = 1;
                }
            }
        }
        return dfs(0,0,M);
    }

    private int dfs(int i,int j,int[][] M){
        if (i<0 || j<0 || i>=M.length || j>=M[i].length || M[i][j] == -1 || M[i][j] == 0){
            return 0;
        }
        int num = 1;
        M[i][j] = 0;
        num += dfs(i+1,j,M);
        num += dfs(i-1,j,M);
        num += dfs(i,j+1,M);
        num += dfs(i,j-1,M);
        return num;
    }

    private int digitNumSum(int m){
        int sum = 0;
        while(m>0){
            sum += m%10;
            m = m/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        movingCountSolution foo = new movingCountSolution();
//        int m = 2, n = 3, k = 1;
        int m = 3, n = 1, k = 0;
        System.out.println(foo.movingCount(m,n,k));
    }
}
