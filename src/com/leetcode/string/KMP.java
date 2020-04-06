package com.leetcode.string;
/*
* 字符串是否包含另一个字符串的位置
* @para:haystack  长的字符串
* @para:needle    短的字符串
* */
public class KMP {
    int strIndex(String haystack, String needle) {
        //conner case
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            if (haystack == needle) {
                return 0;
            }
            return -1;
        }

        //截取判断
        for (int i = 0; i < haystack.length()-needle.length()+1; ++i) {
            String tmp = haystack.substring(i,i+ needle.length());

            if (tmp.equals (needle)) {
                return i;
            }
        }
        return -1;
    }

    public static  void main(String[] agrs) {
        KMP test = new KMP();
        int res = test.strIndex("aaaabcd", "abc");
        System.out.println(res);
    }
}
