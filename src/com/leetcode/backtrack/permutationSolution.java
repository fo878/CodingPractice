package com.leetcode.backtrack;

import java.util.*;

/*输入一个字符串，打印出该字符串中字符的所有排列。*/
/*
* 字符串的全排列
* n个字符的全排列，把第n个字符插入到（n-1个字符的全排列）的n个位置
*
* abcd
* a 的全排列  a   1
*
* ab 的全排列 ab ba  2
*
* abc的全排列为 abc acb bac bca cab cba  3*2=6
*
* abcd的全排列为 dabc dacb dbac dbca dcab dcba   4*3*2 = 24
*               adbc adcb bdac bdca cdab cdba
*               abdc acdb badc bcda cadb cbda
*               abcd acbd bacd bcad cabd cbad
* */
public class permutationSolution {

    private void backtrack(char[] arr,HashSet<String> set,int first){
        if (first == arr.length) set.add(String.copyValueOf(arr));
        for (int i = first; i < arr.length; i++) {
            swap(first,i,arr);
            backtrack(arr,set,first+1);
            swap(first,i,arr);
        }
    }

    public String[] permutation(String s){
        HashSet<String> set = new HashSet<String>();
        int i=0;
        backtrack(s.toCharArray(),set,0);
        String[] res = new String[set.size()];
        for (String string : set) {
            res[i++] = string;
        }
        return res;
    }

    private char[] swap(int i,int j,char[] chars){
        //交换s的第i位与第j位字符
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return chars;
    }

    public static void main(String[] args) {
        permutationSolution foo = new permutationSolution();
        String s = "abc";
        System.out.println(Arrays.toString(foo.permutation(s)));
    }
}
