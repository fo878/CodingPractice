package com.leetcode.play20200418;

import java.util.Arrays;

/*
* 传递信息
* 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
* */
class numWaysSolution2 {
    public static int numWays(int n, int[][] relation, int k) {
        Arrays.sort(relation, (v1, v2) -> v1[0] - v2[0]);
        int count = 0;
        int target = n-1;
        return 0;
    }

    public static void main(String[] args) {
        //输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
        //输出：3
        //解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
        int n = 5;
        int[][] relation = new int[][]{
                {0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
        };
        int k = 3;
        System.out.println(numWays(n,relation,k));
    }
}