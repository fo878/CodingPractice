package com.leetcode.backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* 括号生成
* */
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//例如，给出 n = 3，生成结果为：
//  暴力解法超出时间限制：求一个字符串的全排列，再检查该字符串的括号是否合法
/*
    [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ]

    [
        "(())"
        "()()"
    ]
*/
public class generateParenthesisSolution {
    private static boolean isValid(String s){
        if (s.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (stack.isEmpty() || c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static List<String> generateParenthesis(int n){
        if (n == 0){
            return null;
        }
        LinkedList<String> res = new LinkedList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append("()");
        }
        String first = stringBuffer.toString();
        String[] strings = permutation(first);
        for (int i = 0; i < strings.length; i++) {
            if (isValid(strings[i])){
                res.add(strings[i]);
            }
        }
        return res;
    }

    public static String[] permutation(String s){
        HashSet<String> set = new HashSet<String>();
        int i=0;
        backtrack(s.toCharArray(),set,0);
        String[] res = new String[set.size()];
        for (String string : set) {
            res[i++] = string;
        }
        return res;
    }

    private static void backtrack(char[] arr, HashSet<String> set, int first){
        if (first == arr.length) set.add(String.copyValueOf(arr));
        for (int i = first; i < arr.length; i++) {
            swap(first,i,arr);
            backtrack(arr,set,first+1);
            swap(first,i,arr);
        }
    }

    private static char[] swap(int i,int j,char[] chars){
        //交换s的第i位与第j位字符
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return chars;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis(3);
        System.out.println(strings.toString());
    }
}
