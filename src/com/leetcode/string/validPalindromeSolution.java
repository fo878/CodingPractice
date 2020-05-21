package com.leetcode.string;

/*
680. 验证回文字符串 Ⅱ
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
输入: "abca"
输出: True
解释: 你可以删除c字符。
 */
public class validPalindromeSolution {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindromeSolution foo = new validPalindromeSolution();
        System.out.println(foo.validPalindrome("abc"));
        System.out.println(foo.validPalindrome("abccba"));
        System.out.println(foo.validPalindrome("abcdcba"));
        System.out.println(foo.validPalindrome("abcddddd"));
        System.out.println(foo.validPalindrome(""));
        System.out.println(foo.validPalindrome("abca"));
    }
}