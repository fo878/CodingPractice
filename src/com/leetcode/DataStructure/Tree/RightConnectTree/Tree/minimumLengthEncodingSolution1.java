package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;
/*
*给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/short-encoding-of-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class minimumLengthEncodingSolution1 {

    /*
    * 用HashSet存储所有后缀，如果这个词在别的单词的后缀出现过，就不计算该单词的长度，
    * 如果没出现，就加上这个词的长度再加上1为#的长度
    *
    * 枚举单词所有的后缀。对于每个后缀，如果其存在 words 列表中，我们就将其从列表中删除。
    * 为了高效删除，我们将 words 用哈希集合（HashSet）来存储。
    * */
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word: words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word: good)
            ans += word.length() + 1;
        return ans;
    }
}
