package com.leetcode.string;
/*
国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
所有26个英文字母对应摩尔斯密码表如下：
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。返回我们可以获得所有词不同单词翻译的数量。

例如:
输入: words = ["gin", "zen", "gig", "msg"]
输出: 2
解释:
各单词翻译如下:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

共有 2 种不同翻译, "--...-." 和 "--...--.".
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class uniqueMorseRepresentationsSolution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character,String> map = new HashMap();
        String[] list = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                    ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--",
                "-..-","-.--","--.."};
        for (int i = 0; i < list.length; i++) {
            map.put((char)(i+97),list[i]);
        }
        //检查map，键为“a、b、c”，值为摩尔斯密码
//        for (Character character : map.keySet()) {
//            System.out.println(character);
//        }
//        String[] outString = new String[words.length];
        HashSet<String> set = new HashSet();
        for (int i=0;i<words.length;i++) {
            StringBuffer sb = new StringBuffer();//sb表示翻译后的摩尔斯密码
            char[] alphabet = words[i].toCharArray();
            for (char c : alphabet) {
                sb.append(map.get(c));
            }
//            outString[i] = sb.toString();
            set.add(sb.toString());
        }
        //检查outString
//        System.out.println(Arrays.toString(outString));
        return set.size();
    }

    public static void main(String[] args) {
        uniqueMorseRepresentationsSolution foo = new uniqueMorseRepresentationsSolution();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(foo.uniqueMorseRepresentations(words));
    }
}
