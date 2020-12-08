package com.leetcode.string;
/*
* 43. 字符串相乘

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
* */
public class MutiplySolution {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m+n];
        for (int i = m-1; i >=0 ; i--) {
            int x = num1.charAt(i)-'0';
            for (int j = n-1; j >= 0; j--) {
                int y = num2.charAt(j)-'0';
                ansArr[i+j+1] += x*y;
            }
        }
        for (int i = m+n-1; i > 0 ; i--) {
            ansArr[i-1] += ansArr[i]/10;
            ansArr[i] = ansArr[i]%10;
        }
        int index = ansArr[0] == 0? 1:0;
        StringBuffer ans = new StringBuffer();
        for (; index < m+n; index++) {
            ans.append(ansArr[index]);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String num1 = "1342311";
        String num2 = "564165651616156165165156156";
        System.out.println(multiply(num1,num2));
    }
}
