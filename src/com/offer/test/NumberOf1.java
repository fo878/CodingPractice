package com.offer.test;

import java.util.Arrays;


/*
* 题目： 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*
* 分析：
*       正整数的补码等于其本身
*       负整数的补码等于原码按位取反加一
*       先把整数转化为二进制数，负数取反加一，二进制数转化为字符串，统计字符串中1的个数
*       进制转换在Java的Integer对象中封装好了
*           	Integer.parseInt((String) s,(int) radix);  radix转10进制
*               Integer.toBinaryString(n);                 转2进制
* */
public class NumberOf1 {
    private int count = 0;//统计1的个数

    public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        if (n<0){
            //负数的补码，按位取反加一
            char[] a = str.toCharArray();//将字符串转化为char数组
            for (int i = 0; i < a.length; i++) {
                if (a[i] == '0'){
                    a[i] = '1';
                }else {
                    a[i] = '0';
                }
            }
            String str1 = String.valueOf(a);//将char数组转化为字符串
            Integer m = Integer.valueOf(str1);//字符串转整型
            m = m + 1;
            str = Integer.toBinaryString(m);
        }
        //统计str中有几个1
        char[] b = str.toCharArray();
        for (char c : b) {
            if (c == '1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = -2147483648;
        String str = Integer.toBinaryString(n);
        char[] a = str.toCharArray();
        System.out.println(str);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '0'){
                a[i] = '1';
            }else {
                a[i] = '0';
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(String.valueOf(a));
    }
}
