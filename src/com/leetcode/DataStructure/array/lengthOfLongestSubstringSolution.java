package com.leetcode.DataStructure.array;

import java.util.HashSet;
import java.util.Set;

/*
* 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
* */
public class lengthOfLongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        int i=0,j=0;
        int res = 0;
        while(i<n && j<n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstringSolution foo = new lengthOfLongestSubstringSolution();
        System.out.println(foo.lengthOfLongestSubstring(s));
    }
}
