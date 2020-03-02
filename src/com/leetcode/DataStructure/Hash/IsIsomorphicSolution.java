package com.leetcode.DataStructure.Hash;

import java.util.Arrays;
import java.util.HashMap;

/*
*给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
* 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
*
* 分析：
*   如果两个字符串是同构的，字符数量一定相等
* 方法一：
*   可将s和t分别映射成一串数字，从头遍历，按字符出现的次序，第i个出现的字符为数字i，判断两个数字是否相等
* 方法二：
*   由于存在映射关系，考虑到用Hashmap
*   key为s的一个字符
*   value为t的一个字符
*
* */
public class IsIsomorphicSolution {
    public boolean isIsomorphic(String s, String t) {
        char[] charsA = s.toCharArray();
        char[] charsB = t.toCharArray();
        return Arrays.toString(change(charsA)).equals(Arrays.toString(change(charsB)));
    }

    public int[] change(char[] M){
        int n = M.length;
        HashMap<Character,Integer> map = new HashMap<>();//用于记录字符集以及映射的数字
        int k = 0;//第k个未出现的字符
        int[] res = new int[n];//返回的结果集
        for (int i = 0; i < n; i++) {
            if (map.containsKey(M[i])){
                res[i] = map.get(M[i]);
            }else {
                k++;
                map.put(M[i],k);
                res[i] = k;
            }
        }
        return res;
    }



    /*
    * 方法二：
    * */
    public boolean isIsomorphic1(String s, String t) {
        return isSingleTrack(s,t)&&isSingleTrack(t,s);
    }
    //判断单方向映射是否正确
    public boolean isSingleTrack(String s,String t){
        int n = s.length();
        char[] charsA = s.toCharArray();
        char[] charsB = t.toCharArray();
        HashMap<Character,Character> map = new HashMap<>();//s中的字符记为key，t中的字符记为value
        for (int i = 0; i < n; i++) {
            //s中的一个字符在map中是否存在
            if (map.containsKey(charsA[i])){//如果存在，判断它映射的value与charsB[i]是否相等，不等则返回false
                if (map.get(charsA[i])!=charsB[i]){
                    return false;
                }
            }else { //如果不存在，添加这个字符为key，charsB[i]为value
                map.put(charsA[i],charsB[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abccba";
        String t = "qweewq";
        IsIsomorphicSolution foo = new IsIsomorphicSolution();
        System.out.println(foo.isIsomorphic1(s,t));
    }
}
