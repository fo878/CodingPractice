package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
51. N 皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
上图为 8 皇后问题的一种解法。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

输入：4
输出：[
         [".Q..",  // 解法 1
          "...Q",
          "Q...",
          "..Q."],

         ["..Q.",  // 解法 2
          "Q...",
          "...Q",
          ".Q.."]
      ]
解释: 4 皇后问题存在两个不同的解法。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class NQueensSolution {

    List<List<String>> result = new ArrayList<>();
    //输入棋盘边长n，返回所有合法的放置
    public List<List<String>> solveNQueens(int n) {
        //'.'表示空，'Q'表示皇后，初始化空棋盘。
        char[][] board = new char[n][n];
        for (char[] line : board) {
            Arrays.fill(line,'.');
        }
        backtrack(board,0,n);
        return result;
    }

    public void backtrack(char[][] board, int row,int n){
        if (row==n){//满足结束条件
            List<String> list = new ArrayList<>();
            for (char[] line : board) {
                list.add(String.valueOf(line));
            }
            result.add(list);
            return;
        }
        //for 选择 in 选择列表
        for (int col = 0; col < n; col++) {
            if (isValid(board,row,col)){
                board[row][col] = 'Q';//做选择
                backtrack(board,row+1,n);
                board[row][col] = '.';//撤销选择
            }
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensSolution foo = new NQueensSolution();
        System.out.println(foo.solveNQueens(4));
    }
}
