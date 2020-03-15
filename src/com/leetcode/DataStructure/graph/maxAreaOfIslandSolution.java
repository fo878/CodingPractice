package com.leetcode.DataStructure.graph;
/*
题目：岛屿的最大面积
描述：
    给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
你可以假设二维矩阵的四个边缘都被水包围着。
    找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
示例 :
    {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
    }

* */
public class maxAreaOfIslandSolution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1){
                    max = Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }

    private int dfs(int i,int j,int[][] grid){
        if (i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i+1,j,grid);
        num += dfs(i-1,j,grid);
        num += dfs(i,j+1,grid);
        num += dfs(i,j-1,grid);
        return num;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        maxAreaOfIslandSolution foo = new maxAreaOfIslandSolution();
        System.out.println(foo.maxAreaOfIsland(M));
    }
}
