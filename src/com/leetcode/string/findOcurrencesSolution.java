package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

/*
*给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
* 其中 second 紧随 first 出现，third 紧随 second 出现。
对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

示例：
输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
输出：["girl","student"]

*
*
* */
public class findOcurrencesSolution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> out = new ArrayList<>();
        String[] s = text.trim().split(" ");
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < s.length-2; i++) {
            int j = i+1;
            int k = i+2;
            if (s[i].equals(first) && s[j].equals(second)){
                out.add(s[k]);
            }
        }
        String[] res = new String[out.size()];
        int n = 0;
        for (String s1 : out) {
            res[n] = s1;
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        findOcurrencesSolution foo = new findOcurrencesSolution();
        String[] out = foo.findOcurrences(text, first, second);
        System.out.println(Arrays.toString(out));
    }
}
