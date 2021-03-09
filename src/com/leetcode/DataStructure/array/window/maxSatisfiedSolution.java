package com.leetcode.DataStructure.array.window;
/*
* 1052. 爱生气的书店老板
今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，
所有这些顾客都会在那一分钟结束后离开。
在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 
分析 客户满意数最多
滑动窗口法  窗口大小为X, 数组长度为n = customers.length, 共有n-X+1个窗口
    直观的方法是
MAX(窗口中的客户满意数 + 其他位置的满意数)
滑动窗口 改变的是首尾满意数的值 即：
 * */
class maxDiffSolution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int total = 0; //不生气的总值
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        
        int diff = 0;
        for (int i = 0; i < X; i++) {
            diff += customers[i] * grumpy[i]; //首个窗口 老板忍住不生气时加上的值
        }
        int maxDiff = diff;

        for (int left = 1, right = X; right < n; left++,right++) {
            if (grumpy[left-1] == 1) {
                //原来算上left-1的满意度值了,现在需要减掉
                diff -= customers[left-1];
            }
            if (grumpy[right] == 1) {
                //原来没算上right的满意度值,现在需要加上
                diff += customers[right];
            }
            maxDiff = Math.max(maxDiff,diff);
        }
        return maxDiff + total;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new    int[]{0,1,0,1,0,1,0,1};
        int X = 3;
        maxDiffSolution foo = new maxDiffSolution();
        System.out.println(foo.maxSatisfied(customers,grumpy,X));
    }
}