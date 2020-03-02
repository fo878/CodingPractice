package com.leetcode.test;

import java.util.*;

/*
* 判断字符串中的括号是否合法？
* 1.先有左括号，后有右括号
* #2.大括号包含中括号包含小括号
* 3.“([)]”这种情况也不合法
*
* 实现：
* 1.设计栈的结构，遇到左括号，push，遇到右括号pop，遍历一遍后栈内元素为0时满足条件一
* 2.如果遇到的右括号和pop出来的左括号不是一个类型，则判断括号不合法
*
* */

class Solution {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }

    public boolean isValid1(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        if (stack.empty())
            return true;
        return false;
    }


    public boolean isValid2(String s) {
        Stack<Object> list = new Stack<>();
        String[] parenthesis = {"(", ")", "[", "]", "{", "}"};
        int n = s.length();

        return true;
    }
}
