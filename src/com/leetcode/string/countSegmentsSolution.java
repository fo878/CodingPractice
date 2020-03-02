package com.leetcode.string;
/*
*统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
*
* 示例：
*   输入: "Hello, my name is John"
    输出: 5

* */
public class countSegmentsSolution {
    public int countSegments(String s) {
        if (s.length()==0) return 0;
        String trimed = s.trim();
        return trimed.split("\\s++").length;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        String s1 = ", , , ,        a, eaefa";
        countSegmentsSolution foo = new countSegmentsSolution();
        System.out.println(foo.countSegments(s));
        System.out.println(foo.countSegments(s1));//6
    }
}
