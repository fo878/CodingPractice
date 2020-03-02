package com.leetcode.DataStructure.Hash;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.*;

/*
* 字母异位词分组
* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
*
* 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
* 输出:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
*
* 分析：我们的映射策略可以是：对字符串进行排序并使用排序后的字符串作为键。也就是说，“eat” 和 “ate” 都将映射到 “aet”。
* */
public class groupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> outlist = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {//遍历数组，键为排序后的字符串，值为一个列表，列表中装着多个原始字符串
            String key = sort(strs[i]);
            if (!map.containsKey(key)){
                ArrayList<String> value = new ArrayList<>();
                value.add(strs[i]);
                map.put(key,value);
            }else {
                map.get(key).add(strs[i]);
            }
        }
        //相同value保存在同一个数组

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            outlist.add(map.get(s));
        }
        return outlist;
    }

    public String sort(String str){
        //该方法用于将字符串的字母按顺讯排列,返回一个String
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c);
        }
        Collections.sort(list);
        Object[] array =  list.toArray();
        StringBuffer outstr = new StringBuffer();
        for (Object o : array) {
            outstr.append(o);
        }
        return outstr.toString();
    }

    public static void main(String[] args) {
        String s = "wreiofoasidfjioa";
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagramsSolution foo = new groupAnagramsSolution();
        System.out.println(foo.sort(s));
        List<List<String>> lists = foo.groupAnagrams(input);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
