package com.leetcode.string;
/*
* 844. 比较含退格的字符串
*
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
注意：如果对空文本输入退格字符，文本继续为空。
* */
public class backspaceCompareSolution {
    public boolean backspaceCompare(String S, String T) {
        S = exchange(S);
        System.out.println("S=" + S);
        T = exchange(T);
        System.out.println("T=" + T);
        return S.equals(T);
    }

    private String exchange(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#'){
                sb.append(s.charAt(i));
            }else {
                if (sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "a##c";
        String T = "#a#c";
//        String S = "ab##";
//        String T = "c#d#";
        backspaceCompareSolution foo = new backspaceCompareSolution();
        System.out.println(foo.backspaceCompare(S,T));
    }
}

