package com.leetcode.calculation;
/*

问题：给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 hard

递归的方法
* 我们可以将一个数字拆分为最高位和其右边 ，比如 3452，拆成 3 和 452，
* 最高位 high = 3, last = 452, 数的范围是几千的数字，
* 那么 power = 1000 先看最高位贡献了多少个 1，如果最高位大于1、 那么最高位贡献1000个1，1000~1999
* 那么剩余位贡献多少个1呢，只要看0-999的个、十、百位贡献了多少个1，
* 那么 1000~1999，2000~2999， 的个、十、百位贡献的1的个数都是一样的
* 即high * countDigitOne(power-1)个1
* 最后还剩下3000-3452这last+1个数字的个、十、百位贡献的1的数量，即countDigitOne(last)
* */
public class countDigitOneSolution {
    public int countDigitOne(int n){
        if (n<=0) return 0;
        if (n<10) return 1;
        String s = String.valueOf(n);
        int last = Integer.parseInt(s.substring(1));
        int power = (int)Math.pow(10,s.length()-1);
        int high = s.charAt(0)-'0';//当前字符的ASCII码减去‘0’的ASCII码
        if (high == 1){
            return countDigitOne(last) + countDigitOne(power-1) + last + 1;
        }else {
            return power + high * countDigitOne(power-1) + countDigitOne(last);
        }
    }

    public static void main(String[] args) {
        int n = 1234;
        countDigitOneSolution foo = new countDigitOneSolution();
        System.out.println(foo.countDigitOne(n));;
    }
}
