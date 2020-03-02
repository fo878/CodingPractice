package com.leetcode.test;
/*
小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
他们一共进行三次这个游戏，请返回 小A 猜对了几次？
输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
*/
public class gameSolution {
    public int game(int[] guess, int[] answer) {
        int n = guess.length;
        int out = 0;
        for (int i = 0; i < n; i++) {
            if (guess[i] == answer[i]){
                out++;
            }
        }
        return out;
    }
}
