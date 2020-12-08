package com.leetcode.DataStructure.graph;
/*
* 79. 单词搜索
* 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
* 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
* 同一个单元格内的字母不允许被重复使用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class existSolution {

    public boolean exist(char[][] board, String word) {
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
              {'A','B','C','E'},
              {'S','F','C','S'},
              {'A','D','E','E'}
            };
        String word = "ABCCED";
        existSolution foo = new existSolution();
        System.out.println(foo.exist(board,word));
    }
}
