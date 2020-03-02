package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，
该函数将返回左旋转两位得到的结果"cdefgab"。

*/
public class reverseLeftWordsSolution {
    public String reverseLeftWords(String s, int n) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        StringBuffer res = new StringBuffer();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i<n){
                list2.add(array[i]);
            }else list1.add(array[i]);
        }
        for (Object e : list1) {
            res.append(e);
        }
        for (Object e : list2) {
            res.append(e);
        }
        return res.toString();
    }


    public String reverseLeftWords1(String s, int n) {
        String left = s.substring(0, n);
        String right = s.substring(n);
        return right + left;
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        reverseLeftWordsSolution foo = new reverseLeftWordsSolution();
        System.out.println(foo.reverseLeftWords(s,2));
    }
}
