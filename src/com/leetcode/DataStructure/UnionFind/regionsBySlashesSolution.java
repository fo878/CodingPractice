package com.leetcode.DataStructure.UnionFind;

class regionsBySlashesSolution {

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            // 二维转一维
            for (int j = 0; j < N; j++) {
                int index = 4 * (i * N + j);
                char c = row[j];
                //单元格内合并
                if (c == '/') {
                    // 合并0,3  1,2
                    uf.union(index,index+3);
                    uf.union(index+1,index+2);
                } else if (c=='\\') {
                    // 合并 0,1  2,3
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                } else {
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }

                //单元格间合并
                //向右合并
                if (j + 1 < N) {
                    uf.union(index + 1,4 * (N * i + j + 1) + 3);
                }

                //向下合并
                if (i + 1 < N) {
                    uf.union(index + 2, 4 * (N * (i+1) + j));
                }
            }
        }
        return uf.count();
    }
}
