package com.leetcode.DataStructure.Tree.RightConnectTree.Tree.BST;
/*
* 530. 二叉搜索树的最小绝对差
* 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * */


import java.util.ArrayList;
import java.util.List;

public class getMinimumDifferenceSolution {
    List<Integer> res = new ArrayList<Integer>();
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        int min = Integer.MAX_VALUE;
        int pre = res.get(0);
        for(int i=1;i<res.size();++i){
            int cur = res.get(i);
            int dif = Math.abs(cur-pre);
            min = Math.min(min,dif);
            pre = cur;
        }
        return min;
    }

    private void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}
