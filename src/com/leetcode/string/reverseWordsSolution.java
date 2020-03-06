package com.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

/*
  翻转单词顺序
* 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
* 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

* */
public class reverseWordsSolution {
    public String reverseWords(String s) {
        String[] strings = s.split("\\s+");
        Stack<String> stack = new Stack<String>();
        for (String str : strings) {
            stack.push(str);
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            res.append(stack.pop()).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        reverseWordsSolution foo = new reverseWordsSolution();
        System.out.println(foo.reverseWords("a good   example"));
    }
}
