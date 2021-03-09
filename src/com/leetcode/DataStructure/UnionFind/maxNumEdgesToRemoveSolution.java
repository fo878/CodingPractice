package com.leetcode.DataStructure.UnionFind;

/*
* 1579. 保证图可完全遍历
Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：

类型 1：只能由 Alice 遍历。
类型 2：只能由 Bob 遍历。
类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。
请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。
如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
* */
public class maxNumEdgesToRemoveSolution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //节点编号从0开始
        for (int[] edge : edges) {
            edge[1] -= 1;
            edge[2] -= 1;
        }

        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);

        int ans = 0;

        //公共边,如果两个点是连通的，那么这条公共边不需要连接，所以可去掉数目+1，
        //      如果两个点不是连通的，那么这条公共边需要连接
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufa.connected(edge[1],edge[2])) {
                    ans += 1;
                } else {
                    ufa.union(edge[1],edge[2]);
                    ufb.union(edge[1],edge[2]);
                }
            }
        }

        //独占边
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                //Alice的独占边,如果已经相连，则这个边可以去掉，如果不连则需要把他们连上
                if (ufa.connected(edge[1],edge[2])) {
                    ans += 1;
                } else {
                    ufa.union(edge[1],edge[2]);
                }
            } else if (edge[0] == 2) {
                //Bob的独占边
                if (ufb.connected(edge[1],edge[2])) {
                    ans += 1;
                } else {
                    ufb.union(edge[1],edge[2]);
                }
            }
        }

        //能连的都连了还是不能全联通
        if (ufa.count() != 1 || ufb.count() != 1) {
            return -1;
        }

        //节点编号改为从0开始
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {3, 1, 2},
                {3, 2, 3},
                {1, 1, 3},
                {1, 2, 4},
                {1, 1, 2},
                {2, 3, 4}
        };

        int n = 4;

        int[][] edges1 = new int[][]{
                {1,1,2},{2,2,3},{2,3,4},{1,3,5},{3,2,6},{2,3,7},{3,7,8},{3,2,9},{2,4,10},{2,9,11},{1,2,12},{3,4,13},{2,2,7},{1,1,9},{1,2,13},{2,7,13},{3,2,3},{1,7,10},{2,8,11},{1,2,7},{2,1,9},{2,2,9},{1,5,6},{2,4,9},{1,7,8},{1,4,6},{1,4,9},{3,7,13},{2,2,8},{2,2,6},{1,1,10},{1,1,11},{2,5,10},{1,2,9},{2,1,2},{1,3,4},{3,6,8},{3,6,13},{1,3,8},{1,1,6},{3,3,9},{1,2,3},{1,11,13}
        };

        int n1 = 13;

        maxNumEdgesToRemoveSolution foo = new maxNumEdgesToRemoveSolution();
        System.out.println(foo.maxNumEdgesToRemove(n1,edges1));
    }
}
