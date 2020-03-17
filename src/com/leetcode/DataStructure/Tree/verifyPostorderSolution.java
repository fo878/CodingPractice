package com.leetcode.DataStructure.Tree;

import java.util.Stack;

/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
* 假设输入的数组的任意两个数字都互不相同。


 * */
public class verifyPostorderSolution {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return recur(postorder,0,n-1);
    }

    private boolean recur(int[] postorder,int i,int j){
        if(i >= j) return true;
        int l = i;
        while(postorder[l] < postorder[j]) l++;
        int m = l;
        while(postorder[l] > postorder[j]) l++;
        return l == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    /*单调栈*/
    public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[]={1,3,2,6,5};
        verifyPostorderSolution foo = new verifyPostorderSolution();
        boolean out = foo.verifyPostorder(arr);
        System.out.println(out);
    }
}
