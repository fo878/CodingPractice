package com.leetcode.DataStructure.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 290. 单词规律
// 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
// 说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
class wordPatternSolution {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (chars.length != strings.length) {
            return false;
        }
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (str2ch.containsKey(strings[i]) && str2ch.get(strings[i]) != chars[i]) {
                return false;
            }
            if (ch2str.containsKey(chars[i]) && !ch2str.get(chars[i]).equals(strings[i])) {
                return false;
            }
            str2ch.put(strings[i], chars[i]);
            ch2str.put(chars[i], strings[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        wordPatternSolution foo = new wordPatternSolution();
        System.out.println(foo.wordPattern(pattern,s));
    }
}