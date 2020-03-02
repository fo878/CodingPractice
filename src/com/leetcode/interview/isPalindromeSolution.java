package com.leetcode.interview;
/*
* 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
* 说明：本题中，我们将空字符串定义为有效的回文串。
*
* 字母（a-z）  数字（0-9）
* 输入: "A man, a plan, a canal: Panama"
* 输出: true
* */
public class isPalindromeSolution {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        isPalindromeSolution foo = new isPalindromeSolution();
        System.out.println(foo.isPalindrome(s));
    }
}
