package com.leetcode.DataStructure.UnionFind;
/*
* 765. 情侣牵手
*
* N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
*
* i和j两个人是情侣的条件
* 1. Math.abs(row[j] - row[i]) = 1
* 2. Math.max(row[i],row[j]) % 2 = 1
*
* 通过x找到他的情侣y
* if(x%2==0) {
*   y = x + 1;
* } else {
*   y = x - 1;
* }
*
* 从前往后遍历，每次遍历两个数
* 判断他们是否是情侣
* 如果是情侣则继续向前遍历
* 如果不是情侣，保留他们两个中最小的数x，计算x的情侣y的值
* 二分查找法在剩余座位中找到y
* 交换位置(max(i,j),y所在的位置k)使得x,y坐在一起
* 继续向前遍历直到所有人都组成了情侣
*
* * *但是这样的方法只能保证所有人都组成了情侣，却无法保证交换次数最少？
* 交换次数最少，如果采用贪心的思想，就是位置正确的情侣们不动
* 原位置如果是(0,2)(1,3)这样的组合，2和1换一次就可以解决两对情侣
* 原位置如果是(0,3)(1,4)(2,5)  需要换两次才行
* */
class minSwapsCouplesSolution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < len; i+=2) {
            uf.union(row[i]/2,row[i+1]/2);
        }
        return N - uf.count();
    }

    public static void main(String[] args) {
//        int[] row = new int[]{0,2,1,3};
        int[] row = new int[]{5,4,2,6,3,1,0,7};
        minSwapsCouplesSolution foo = new minSwapsCouplesSolution();
        System.out.println(foo.minSwapsCouples(row));
    }

}