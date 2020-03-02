package com.offer.test;

import java.util.HashSet;

/*
* 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例：
*   输入: J = "aA", S = "aAAbbbb"
    输出: 3


* */
public class numJewelsInStonesSolution {
    public int numJewelsInStones(String J, String S) {
        int out = 0;
        char[] chars1 = J.toCharArray();
        char[] chars2 = S.toCharArray();
        HashSet set = new HashSet();
        for (char c : chars1) {
            set.add(c);
        }
        for (char c : chars2) {
            if (set.contains(c)){
                out++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        numJewelsInStonesSolution foo = new numJewelsInStonesSolution();
        int out = foo.numJewelsInStones(J,S);
        System.out.println(out);
    }
}
