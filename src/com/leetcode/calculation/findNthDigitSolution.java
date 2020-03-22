package com.leetcode.calculation;
/*
* 数字序列中某一位的数字
*
* 数字以0123456789101112131415…的格式序列化到一个字符序列中。
* 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。
* */
public class findNthDigitSolution {
/*暴力法*/
    public int findNthDigit(int n) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i<=n){
            sb = sb.append(i++);
        }
        int res = sb.charAt(n)-'0';
        return res;
    }

    

    public static void main(String[] args) {
        findNthDigitSolution foo =  new findNthDigitSolution();
        System.out.println(foo.findNthDigit(19));
    }
}
