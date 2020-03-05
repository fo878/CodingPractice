package com.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/*
* 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
* */
public class firstUniqCharSolution {
    public char firstUniqChar1(String s) {
        //超出时间限制
        char[] chars = s.toCharArray();
        boolean[] mark = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]){
                    mark[i] = true;
                    mark[j] = true;
                }
            }
        }
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == false){
                return chars[i];
            }
        }
        return ' ';
    }

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n==0){
            return ' ';
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else {
                map.put(chars[i],1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1){
                return chars[i];
            }
        }
        return ' ';
    }
/*--------------官方答案---------------------------------*/
    public char firstUniqChar2(String s) {
        if(s.equals("")) return ' ';
        int[] target = new int[26];
        for(int i=0;i<s.length();i++){
            target[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(target[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}
