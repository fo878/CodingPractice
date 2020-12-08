package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 763. 划分字母区间 字符串 S
 * 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 */
class partitionLabelsSolution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;//找到每个字符出现的最后一个位置
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }


    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        partitionLabelsSolution foo = new partitionLabelsSolution();
        List<Integer> res = foo.partitionLabels(S);
        System.out.println(res.toString());
    }

}