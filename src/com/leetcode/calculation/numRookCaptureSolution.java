package com.leetcode.calculation;

import java.util.Arrays;

/*
* 车的可用捕获量
* 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
* 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
* 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
* 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
* 另外，车不能与其他友方（白色）象进入同一个方格。
* 返回车能够在一次移动中捕获到的卒的数量。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/available-captures-for-rook
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class numRookCaptureSolution {
    public int numRookCaptures(char[][] board) {
        int cnt = 0, start = 0, end = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    start = i;
                    end = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int step = 0;; ++step) {
                int tx = start + step * dx[i];
                int ty = end + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') break;
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        //白车R，白象B，黑卒P
        char[][] board = {
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','B','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        numRookCaptureSolution foo = new numRookCaptureSolution();
        System.out.println(foo.numRookCaptures(board));
    }
}
