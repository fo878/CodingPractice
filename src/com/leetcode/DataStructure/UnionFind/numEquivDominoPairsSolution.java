package com.leetcode.DataStructure.UnionFind;
/*
* 1128. 等价多米诺骨牌对的数量
* */
public class numEquivDominoPairsSolution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int count = 0;
        for (int[] dominoe : dominoes) {
            int val;
            if (dominoe[0] <= dominoe[1]) {
                val = dominoe[0] * 10 + dominoe[1];
            } else {
                val = dominoe[1] * 10 + dominoe[0];
            }
            count += num[val];
            num[val] += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] dominoes1 = {{1,2},{2,1},{3,4},{5,6}};
        numEquivDominoPairsSolution foo = new numEquivDominoPairsSolution();
        System.out.println(foo.numEquivDominoPairs(dominoes1));
    }
}
