package com.leetcode.DataStructure.graph;
/*
* 657. 机器人能否返回原点
* */
class judgeCircleSolution {
    public boolean judgeCircle(String moves) {
        int[] move = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                move[0] += 1;
            }
            if (moves.charAt(i) == 'D') {
                move[1] += 1;
            }
            if (moves.charAt(i) == 'L') {
                move[2] += 1;
            }
            if (moves.charAt(i) == 'R') {
                move[3] += 1;
            }
        }
        return move[0] == move[1] && move[2]==move[3];
    }
}