package com.leetcode.DP;

import java.util.Arrays;

/*

    Hard
    你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
    每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
    你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
    每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
    你的目标是确切地知道 F 的值是多少。
    无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？

* */
public class superEggDropSolution {

    public static int superEggDrop(int K, int N) {
        int res = 0;
        int[][] dp = new int[K+1][N+1];
        
        return res;
    }

    public static void main(String[] args) {
        int k = 1;
        int n = 3;
        System.out.println(superEggDrop(k,n));
    }
}
