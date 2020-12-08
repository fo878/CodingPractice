package com.leetcode.DataStructure.graph;
/*
* 463
* */
//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 285 👎 0

class islandPerimeterSolution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==0){
                    continue;
                } else {
                    count += dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0){
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        islandPerimeterSolution foo = new islandPerimeterSolution();
        System.out.println(foo.islandPerimeter(grid));
    }
}

