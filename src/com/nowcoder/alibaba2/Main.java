package com.nowcoder.alibaba2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
有一个方格游戏是这样：给一个n*n的矩阵，矩阵每一个位置都有一个值，初始的时候在左上角出发，并获得该位置的值作为初始能量
每一次可以选择，上下左右四个方向中的一个，并且可以移动的距离不大于K，且要保证到达的格子的值要比当前位置的格子的值要大
否则不能移动到这个格子，当无法移动时游戏结束。
现在想知道在所有可能的走的方案中，到达的位置的格子值相加总和最大为多少。

input：
1
3 1
1  2  5
10 11 6
12 12 7

第一行，T组测试数据，
第二行，n=3矩阵的大小，k=1每一步最多能走多少个格子
接下来n行，每一行n个数代表矩阵A的元素

output：
37 = 1+2+5+6+11+12

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] array = new int[strings.length];
    }
}
