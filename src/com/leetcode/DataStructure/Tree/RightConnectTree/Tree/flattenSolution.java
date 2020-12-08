package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
* 114. 二叉树展开为链表
* 给定一个二叉树，原地将它展开为一个单链表。
* */
public class flattenSolution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
