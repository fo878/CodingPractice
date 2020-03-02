package com.offer.test;

import java.util.Arrays;

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
*
* 分析：
*   1个台阶  1
*   2个台阶  2
*   3个台阶  3
*   4个台阶  1 1 1 1一种；1 2 1；1 1 2； 2 1 1三种；2 2一种；  共5种
*   5个台阶  1 1 1 1 1一种；2 1 1 1四种；2 2 1三种；共8种
*   6个台阶  六个一 一种
*            一个二 五种
*            两个二 2 2 1 1 ；2 1 2 1 ；1 1 2 2；1 2 1 2；2 1 1 2；1 2 2 1；六种
*            三个二 一种   共13种
* 斐波那契数列 0,1,1,2,3,5,8,13,21,34,55..
* 第一位为0，往后为初始值1和2 的斐波那契数列 0,1,2,3,5,8,13....
* */
public class JumpFloor {
    public int JumpFloor(int n) {
        int[] a = new int[n+1];
        if (n<=3){
            a[n]=n;
            return a[n];
        }
        else {
            for (int i = 0; i <= n; i++) {
                if (i<=3){
                    a[i]=i;
                }
                if (i>3) {
                    a[i] = a[i - 1] + a[i - 2];
                }
            }
            return a[n];
        }
    }
    public static void main(String[] args) {
        JumpFloor j = new JumpFloor();
        int[] ans1 = new int[20];
        for (int i = 0; i < 20; i++) {
            int a = j.JumpFloor(i);
            ans1[i] = a;
        }
        System.out.println("ans1=" + Arrays.toString(ans1));
    }
}
