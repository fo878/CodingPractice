package com.leetcode.DataStructure.Tree.RightConnectTree.Tree.FenwickTree;

/**
 * 树状数组的数据结构
 */
public class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int n) {
        this.len = n;
        tree = new int[n+1];
    }

    /**
     * 单点更新
     * @param i 原数组索引
     * @param delta 变化值=更新后的值-原始值
     */
    public void update(int i, int delta){
        // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
        while(i<=len){
            tree[i] += delta;
            i += lowbit(i);
        }
    }

    /**
     * 查询前缀和
     * @param i 前缀的最大索引
     * @return 查询区间[0,i]的所有元素之和
     */
    public int query(int i){
        //从右到左查询
        int sum = 0;
        while (i>0){
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    private static int lowbit(int x) {
        return x & (-x);
    }


}
