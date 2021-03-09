package com.leetcode.DataStructure.UnionFind;
/*
* 547. 省份数量
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，
那么城市 a 与城市 c 间接相连。
省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
而 isConnected[i][j] = 0 表示二者不直接相连。
返回矩阵中 省份 的数量。
 * */
class findCircleNumSolution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt += 1;
                dfs(i, visited,isConnected);
            }
        }
        return cnt;
    }

    private void dfs(int i, boolean[] visited, int[][] isConnected) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            //遍历与i相邻的节点
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(j,visited,isConnected);
            }
        }
    }

    public int findCircleNumWithUnionFind(int[][] isConnected) {
        int n = isConnected.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // 返回最终合并后的集合的数量
        return uf.count();
    }
}