package com.leetcode.calculation;

import java.util.Arrays;

/*
* 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
* 给出两个整数 x 和 y，计算它们之间的汉明距离。
* */
public class hammingDistanceSolution {
    public int hammingDistance(int x, int y) {
        StringBuffer s1 = new StringBuffer(Integer.toBinaryString(x));
        StringBuffer s2 = new StringBuffer(Integer.toBinaryString(y));
        if (s1.length()<s2.length()){
            return hammingDistance(y,x);
        }
        while (s1.length()>s2.length()){
            s2.insert(0,'0');
        }
        int num = 0;
        char[] c1 = s1.toString().toCharArray();
        char[] c2 = s2.toString().toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 4;
        hammingDistanceSolution foo = new hammingDistanceSolution();
        int i = foo.hammingDistance(x, y);
        System.out.println(i);
    }
}
