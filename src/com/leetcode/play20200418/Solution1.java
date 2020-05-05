package com.leetcode.play20200418;
/*
* 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
* 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，
* 求拿完所有力扣币的最少次数。
示例 1：
输入：[4,2,1]
输出：4
解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
* */
class Solution1 {
    public static int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            while (coins[i]>0){
                count++;
                coins[i] -= 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = new int[]{2,3,10};
        System.out.println(minCount(in));
    }
}