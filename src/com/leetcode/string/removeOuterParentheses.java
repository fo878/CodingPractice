package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
* 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，
* 其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
* 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
* 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive）,
* 其中 A 和 B 都是非空有效括号字符串。
* 给出一个非空有效字符串 S，考虑将其进行原语化分解，
* 使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
* 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
*
*
* 示例：
        输入："(()())(())"
        输出："()()()"
        解释：
        输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
        删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
* */
public class removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();//用于分解
        ArrayList<String> list = new ArrayList<>();//用于存放 P_i 
        StringBuffer string_cur = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(chars[i]);
                string_cur.append(chars[i]);
            }else if (chars[i] == ')' && !stack.isEmpty()){
                stack.pop();
                string_cur.append(')');
            }
            if (stack.isEmpty()){
                int n = string_cur.length();
                String subString_cur = string_cur.substring(1,n-1);
                list.add(subString_cur);
                string_cur = new StringBuffer();
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String S = "(()())(())";
        removeOuterParentheses foo = new removeOuterParentheses();
        System.out.println(foo.removeOuterParentheses(S));
    }
}
