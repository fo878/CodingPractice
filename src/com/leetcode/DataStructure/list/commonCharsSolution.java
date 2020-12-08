package com.leetcode.DataStructure.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 1002. 查找常用字符
*
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。
* */
public class commonCharsSolution {


    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        String s1 = A[0];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (set.contains(c)){
                continue;
            }else {
                set.add(c);
                int minCNums = count(c,s1);
                for (int j = 1; j < A.length; j++) {
                    int CNums = count(c,A[j]);
                    minCNums = Math.min(minCNums,CNums);
                }
                for (int j = 0; j < minCNums; j++) {
                    res.add(String.valueOf(c));
                }
            }
        }
        return res;
    }

    private int count(char c, String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c){
                cnt += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"bella","label","roller"};
        commonCharsSolution foo = new commonCharsSolution();
        List<String> res = foo.commonChars(A);
        System.out.println(res.toString());
    }
}
