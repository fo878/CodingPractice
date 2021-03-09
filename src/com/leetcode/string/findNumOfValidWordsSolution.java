package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 1178. 猜字谜
*
外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
单词 word 中包含谜面 puzzle 的第一个字母。
单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；
而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。

* */
class findNumOfValidWordsSolution {
//word 包含 puzzle 的首字符
//word 中的所有字符都存在于 puzzle 中
//满足条件的 word 和 puzzle，前者是后者的谜底，求：每个 puzzle 的谜底的个数。
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        /*
        * 这道题只会出现小写字母，种类最多是26种，而且单词的字符只要在puzzle里出现了就行。
        * 即对每个字符来说，就2种状态：出现与否，可以用 0/1 来表示这种相对的状态。
        * 出现过的字符记为1，否则为0，比如 abc:111，aacc:101，zab:1000…0011（26位）
        * 遍历单词数组，求出单词对应的二进制数，存入map，统计对应的次数，因为有些单词对应同一个二进制数，比如 abc 和 aaabbc 都是 111。
        * */
        HashMap<Integer,Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int bit = getBit(word);
            wordMap.put(bit,wordMap.getOrDefault(bit,0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            int bit = getBit(puzzle);
            int first = puzzle.charAt(0) - 'a';//首字符对应的整数

            int t = bit, count = 0;
            while (t>0){
                if (((1<<first) & t) != 0 && wordMap.getOrDefault(t,0) > 0) {
                    count += wordMap.get(t);
                }
                t = (t-1) & bit;
            }
            ans.add(count);
        }
        return ans;
    }

    private int getBit(String str) {
        //word转成用二进制数表示的字符集合
        char[] array = str.toCharArray();
        int res = 0;
        for (char c : array) {
            int offset = c - 'a';   //当前字符与'a'的偏移位
            int status = 1 << offset; //将二进制的1左移offset位，右边用0填充
            res = res | status;       //按位或，这个字符出现过就位1，没出现过就为0
        }
        return res;
    }
}