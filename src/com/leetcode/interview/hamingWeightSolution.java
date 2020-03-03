package com.leetcode.interview;

public class hamingWeightSolution {
    /*请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
*/
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        char[] chars = s.toCharArray();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                count++;
            }
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        hamingWeightSolution foo = new hamingWeightSolution();
        int i = foo.hammingWeight1(11);
        System.out.println(i);
    }
}
