package com.leetcode.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class rangeSumBSTSolution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        List list = inorderTraversal(root);
        int sum = 0;
        int start = list.indexOf(L);
        int end = list.indexOf(R);
        for(int i=start;i<=end;i++){
            sum = sum + (int)list.get(i);
        }
        return sum;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            output.add(cur.val);
            cur = cur.right;
        }
        return output;
    }
}
