package com.leetcode.string;

import java.util.Stack;

/*

给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
字符（'a' - 'i'）分别用（'1' - '9'）表示。
字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
返回映射之后形成的新字符串。
题目数据保证映射始终唯一。

示例：
    输入：s = "10#11#12"
    输出："jkab"
    解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

*/
public class freqAlphabetsSolution {
    public String freqAlphabets(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                stack.push((char) (chars[i] - '0' + 96)); // a的ASCII为97
            } else {
                stack.pop();
                stack.pop();
                int digit = (chars[i-2] - '0') * 10 + chars[i-1] - '1';
                char letter = (char) (digit + 'a');
                stack.push(letter);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character C : stack) {
            sb.append(C);
        }
        return sb.toString();
    }

    public String freqAlphabets1(String s) {
        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<ch.length; i++){
            if(i+2<ch.length && ch[i+2]=='#'){
                ans.append((char)(((ch[i] - '0') * 10)+ (ch[i + 1] - '1') + 'a'));
                i += 2;
            } else {
                ans.append((char)(ch[i]-'1'+'a'));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        freqAlphabetsSolution foo = new freqAlphabetsSolution();
        String s = "10#11#12";
        String s1 = "1326#";
        String s3 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(foo.freqAlphabets(s));
        System.out.println(foo.freqAlphabets(s1));
        System.out.println(foo.freqAlphabets(s3));//abcdefghijklmnopqrstuvwxyz
    }
}
