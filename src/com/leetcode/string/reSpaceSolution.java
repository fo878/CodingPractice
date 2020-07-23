package com.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 面试题 17.13. 恢复空格
*
* 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
* 像句子"I reset the computer. It still didn’t boot!"
* 已经变成了"iresetthecomputeritstilldidntboot"。
* 在处理标点符号和大小写之前，你得先把它断成词语。
* 当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
* 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

注意：本题相对原题稍作改动，只需返回未识别的字符数
* */
public class reSpaceSolution {
    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public int respace(String[] dictionary, String sentence) {
        Set<Long> hashValues = new HashSet<Long>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    public long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }
}
