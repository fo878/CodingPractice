package com.leetcode.DataStructure.UnionFind;
//1631. 最小体力消耗路径
/*
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，
其中 heights[row][col] 表示格子 (row, col) 的高度。
一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
请你返回从左上角走到右下角的最小 体力消耗值 。
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class minimumEffortPathSolution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        //构造图中所有边，edge[节点1，节点2，边的权值]
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = n * i + j;
                if (i>0) {
                    edges.add(new int[]{
                            index-n,
                            index,
                            Math.abs(heights[i][j]-heights[i-1][j])
                    });
                }
                if (j>0) {
                    edges.add(new int[]{
                            index-1,
                            index,
                            Math.abs(heights[i][j]-heights[i][j-1])
                    });
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });


        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int v = edge[2];
            uf.union(x,y);
            if (uf.connected(0,m*n-1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {4,3,4,10,5,5,9,2},
                {10,8,2,10,9,7,5,6},
                {5,8,10,10,10,7,4,2},
                {5,1,3,1,1,3,1,9},
                {6,4,10,6,10,9,4,6}
        };
        minimumEffortPathSolution foo = new minimumEffortPathSolution();
        System.out.println(foo.minimumEffortPath(heights));
    }
}