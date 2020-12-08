package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;
/*
* 404. 左叶子之和
* 计算给定二叉树的所有左叶子之和。
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class sumOfLeftLeavesSolution {

    int sumOfLeft = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null){
            return 0;
        }
        help(root);
        return sumOfLeft;
    }

    private void help(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left != null){
            if (root.left.left == null && root.left.right==null){
                sumOfLeft += root.left.val;
            }
            help(root.left);
        }
        if (root.right != null){
            help(root.right);
        }
    }
}

public class sumOfLeftLeavesMainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new sumOfLeftLeavesSolution().sumOfLeftLeaves(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}