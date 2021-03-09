package com.leetcode.greedy;
/*
* 738. 单调递增的数字
* */
public class monotoneIncreasingDigitsSolution {
    public int monotoneIncreasingDigits(int N) {
        if (N<10) return N;
        char[] strN = Integer.toString(N).toCharArray();
        int len = strN.length;
        for (int i = len-1; i > 0 ; i--) {
            if (strN[i] < strN[i-1]) {
                strN[i-1] -= 1;
                for (int j = i; j < len; j++) {
                    strN[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(strN));
    }

    public static void main(String[] args) {
        int n = 332;
        monotoneIncreasingDigitsSolution foo = new monotoneIncreasingDigitsSolution();
        System.out.println(foo.monotoneIncreasingDigits(n));
    }
}
