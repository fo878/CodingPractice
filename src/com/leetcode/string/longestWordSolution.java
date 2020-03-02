package com.leetcode.string;

import java.util.*;

/*
* 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
* 若其中有多个可行的答案，则返回答案中字典序最小的单词。
* 若无答案，则返回空字符串。

* 示例：
        输入:  words = ["w","wo","wor","worl", "world"]
        输出: "world"
        解释: 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

* */
public class longestWordSolution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words1 = {"w", "wo", "wor", "worl", "world"};
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        longestWordSolution foo = new longestWordSolution();
        System.out.println(foo.longestWord(words1));
        System.out.println(foo.longestWord(words2));
    }
}
