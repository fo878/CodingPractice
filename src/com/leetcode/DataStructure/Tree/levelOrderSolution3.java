package com.leetcode.DataStructure.Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/*
*  层序遍历  之字打印
* 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
* 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
* */
public class levelOrderSolution3 {
    List<List<Integer>> levels = new LinkedList<List<Integer>>();

    public void help(TreeNode node, int level){

        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        if (level%2==0){
            int n = levels.get(level).size();
            levels.get(level).add(n,node.val);
        }else {
            levels.get(level).add(0,node.val);
        }


        if (node.left != null){
            help(node.left,level + 1);
        }
        if (node.right != null){
            help(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return levels;
        }
        help(root,0);
        return levels;
    }
}
