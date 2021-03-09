package com.leetcode.greedy;
/*
605. 种花问题
假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
* */
class canPlaceFlowersSolution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0,len=flowerbed.length; i < len && n>0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i==len-1 || flowerbed[i+1] == 0) {
                //该位置是0，且（在最后一位 或 下一位置是0)
                n -= 1;
                i += 2;
            } else {
                //该位置是0，不在最后一位，下一位是1，该位置、下一位、下2位都种不了，010
                i += 3;
            }
        }
        return n<=0;
    }
}