package com.leetcode.DataStructure.Tree;

import java.util.*;

/*
* 括号生成
* */
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//例如，给出 n = 3，生成结果为：
//  暴力解法超出时间限制：求一个字符串的全排列，再检查该字符串的括号是否合法
//  回溯法：如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
//  深度优先搜索：
/*
    [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
    ]
*/
public class generateParenthesisSolution {

    public static List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<String>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public static void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max){
        //回溯算法
        //如果左括号数量不大于 n，我们可以放一个左括号。
        //如果右括号数量小于左括号的数量，我们可以放一个右括号。
        if (cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }

        if (open<max){
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close<open){
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    /*------------------------------dfs----------------------------------------------*/

    List<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis2(int n){
        StringBuilder sb = new StringBuilder("");
        dfs(sb,n,n);
        return ans;
    }

    public void dfs(StringBuilder sb,int left,int right){
        if (left == 0 && right==0){
            ans.add(sb.toString());
            return;
        }
        if (left>right) return;
        if (left>0){
            dfs(sb.append('('),left-1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right>0){
            dfs(sb.append(')'),left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
/*------------------------dp----------------------------*/
    public List<String> generateParenthesis3(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0) return null;
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n ; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i-1-j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" +s2;
                        temp.add(el);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        int n = 3;
        generateParenthesisSolution foo = new generateParenthesisSolution();
        List<String> strings = foo.generateParenthesis3(n);
        System.out.println(strings.toString());
    }
}
