package com.leetcode.DataStructure.graph;
/*
* 矩阵中的路径(dfs)
* 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
* 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
* 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
* */
public class pathExist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int k = 0;//k为chars的指针
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board,words,i,j,k)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word[k]) return false;
        if(k == word.length-1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board,word,i+1,j,k+1) ||
                dfs(board,word,i-1,j,k+1) ||
                dfs(board,word,i,j+1,k+1) ||
                dfs(board,word,i,j-1,k+1);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        char[][] board1 = {
                {'A'}
        };
        String word = "A";
        pathExist foo = new pathExist();
        System.out.println(foo.exist(board1,word));
    }
}
