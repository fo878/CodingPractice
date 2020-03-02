package com.leetcode.DataStructure.Hash;

import java.util.HashMap;

/*
* 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
*
* 分析：
*   这道题最优的解法就是线性复杂度了，为了保证每个元素是唯一的，至少得把每个字符都遍历一遍。
*   算法的思路就是遍历一遍字符串，然后把字符串中每个字符出现的次数保存在一个散列表中。
*   这个过程的时间复杂度为 O(N)O(N)，其中 NN 为字符串的长度。
*   接下来需要再遍历一次字符串，这一次利用散列表来检查遍历的每个字符是不是唯一的。
*   如果当前字符唯一，直接返回当前下标就可以了。
*   第二次遍历的时间复杂度也是 O(N)O(N)。
* */
public class FirstUniqCharSolution {
    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap();//key中保存字符，value保存该字符出现的次数
        for (int i = 0; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])){
                map.put(charArray[i],1);
            }else {
                map.put(charArray[i],map.get(charArray[i])+1);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i])==1){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        FirstUniqCharSolution foo = new FirstUniqCharSolution();
        System.out.println(foo.firstUniqChar(s1));
        System.out.println(foo.firstUniqChar(s2));
    }
}
