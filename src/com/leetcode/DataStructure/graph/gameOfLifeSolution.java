package com.leetcode.DataStructure.graph;

import java.util.Arrays;

/*
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/game-of-life
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class gameOfLifeSolution {
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = bfs(tmp,i,j);
                //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                //如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                if (tmp[i][j] == 1) {
                    if (count < 2) {
                        board[i][j] = 0;
                    } else if (count == 2 || count == 3) {
                        continue;
                    } else if (count>3){
                        board[i][j] = 0;
                    }
                }else {
                    //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (count == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    private static int bfs(int[][] board,int i,int j){
        //统计(i,j)周围的八个细胞有多少个活细胞（数值为1）
        int[] dx = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] dy = new int[]{-1,0,1,-1,1,-1,0,1};
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x = i+dx[k];
            int y = j+dy[k];
            if (x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!=1){
                continue;
            }else count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
