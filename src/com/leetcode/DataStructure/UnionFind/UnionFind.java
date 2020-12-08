package com.leetcode.DataStructure.UnionFind;
/*
数组实现并查集的数据结构
*/

class UnionFind {
    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的“重量”
    private int[] size;

    /*
    * 初始化一个并查集
    * 初始所有节点互不相连，所以连通分量的个数为n，每棵树的重量都为1
    * */
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /*
    * 让p和q的根相连，并且让树的高度最小
    * */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return;
        }
        //小树要接到大树下面会比较平衡
        if (size[rootP]>size[rootQ]){
            parent[rootQ] = rootP;//Q的重量小，Q接到P上，Q的父节点为P
            size[rootP] += size[rootQ];//更新P的重量，为原来的重量+Q的重量
        }else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count -= 1;//联合两个点后，连通分量-1
    }

    /*
     * 判断p和q是否连通
     * */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }

    /*
    * 找到与x相连的根，并进行路径压缩
    * */
    public int find(int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /*
    * 求连通分量
    * */
    public int count(){
        return count;
    }
}