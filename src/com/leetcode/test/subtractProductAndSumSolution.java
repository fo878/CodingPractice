package com.leetcode.test;
/*
* 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
* */
public class subtractProductAndSumSolution {
    public int subtractProductAndSum(int n) {
        if (n==0){
            return 0;
        }
        int product = 1;
        int sum = 0;
        while (n>0){
            product = product*(n%10);
            sum = sum+(n%10);
            n = n/10;
        }
        return product-sum;
    }

    public static void main(String[] args) {
        /*
        * 输入：n = 234
          输出：15

            输入：n = 4421
            输出：21
        * */
        int n1 = 234;
        int n2 = 4421;
        subtractProductAndSumSolution foo = new subtractProductAndSumSolution();
        System.out.println(foo.subtractProductAndSum(n1));
        System.out.println(foo.subtractProductAndSum(n2));
    }
}
