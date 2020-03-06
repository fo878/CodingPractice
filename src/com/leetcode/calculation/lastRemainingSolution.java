package com.leetcode.calculation;
/*
* 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

* 递推关系式：f(n,m) = (f(n-1,m)+m) mod n
* f(1,m) = 0
* */
public class lastRemainingSolution {
    public int lastRemaining(int n, int m) {
        if (n==1){
            return 0;
        }else {
            return (lastRemaining(n-1,m)+m)%n;
        }
    }

    //迭代
    public int lastRemaining1(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }


    public static void main(String[] args) {
        lastRemainingSolution foo = new lastRemainingSolution();
        System.out.println(foo.lastRemaining(5,3));//3
        System.out.println(foo.lastRemaining(10,17));//2
    }
}
