package com.leetcode.calculation;
/*
* 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class myPow {
    public double myPow(double x, int n) {//通不过测试
        if (x==0){
            return 0;
        }
        if (n==0){
            return 1;
        }
        double res = x;
        if (n>0) {
            for (int i = 1; i < n; i++) {
                res = res * x;
            }
        }else {
            n = -n;
            for (int i = 1; i < n; i++) {
                res = res * x;
            }
            res = 1/res;
        }
        return res;
    }

/*-------------------------------------------------------*/
    /*二分法*/
    private double divideSolution(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = divideGenerate(x, Math.abs((long) n));
        return n >= 0 ? v : 1 / v;
    }

    private double divideGenerate(double x, long n) {
        if (n < 2) {
            return x;
        }
        double sub = divideGenerate(x, n / 2);
        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;
        System.out.println(new myPow().myPow(x,n));
    }
}
