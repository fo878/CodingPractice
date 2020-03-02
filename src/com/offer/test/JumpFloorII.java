package com.offer.test;

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*
* 分析：
*   1  1                      一种  2^0
*   2  1+1=2                  二种  2^1
*   3  1 1 1； 1 2； 2 1； 3； 四种  2^2
*   4  1 1 1 1；一种
*      2个1+1个2 三种
*      2个2      一种
*      3+1       两种
*      4         一种         共八种 2^3
* */


import java.util.Arrays;

public class JumpFloorII {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        JumpFloorII j = new JumpFloorII();
        int[] ans1 = new int[20];
        for (int i = 0; i < 20; i++) {
            ans1[i]  = j.JumpFloorII(i);
        }
        System.out.println("ans1=" + Arrays.toString(ans1));
    }
}
