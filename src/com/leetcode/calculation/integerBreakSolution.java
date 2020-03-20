package com.leetcode.calculation;
/*给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
* 题解：
*   https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
* */
public class integerBreakSolution {
    public int integerBreak(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        int n =10;
        integerBreakSolution foo = new integerBreakSolution();
        System.out.println(foo.integerBreak(n));
    }
}
