package com.leetcode.DataStructure.array;
/*
* 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
* */
public class addDigitsSolution {
    public int addDigits(int num) {
        if (num<10)  return num;
        else {
            int sum = 0;
            while (num>10){
                sum += num%10;
                num = num/10;
            }
            sum = sum+num;
            System.out.println(sum);
            return addDigits(sum);
        }
    }

    public static void main(String[] args) {
        int num = 38;
        addDigitsSolution foo = new addDigitsSolution();
        System.out.println(foo.addDigits(38));
    }
}
