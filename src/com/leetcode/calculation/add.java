package com.leetcode.calculation;
/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
*
* 二进制
* 按位异或求和不计进位
* 按位与并左移一位求进位
*
* */
public class add {
    public int add(int a, int b) {
        while (b != 0) {
            int plus = (a ^ b); // 求和（不计进位）. 相同位置0，相反位置1
            b = ((a & b) << 1); // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
            a = plus;
        }
        return a;
    }
}
