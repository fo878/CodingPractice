package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 平衡二叉树
* 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
* 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
* */
class isBalancedMainClassSolution {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }else {
            boolean flag = Math.abs(treeDepth(root.left)-treeDepth(root.right))<=1;
            return flag && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }else if (root.left == null){
            return treeDepth(root.right)+1;
        }else if(root.right==null){
            return treeDepth(root.left)+1;
        }else{
            return Math.max(treeDepth(root.left),treeDepth(root.right))+1;
        }
    }
}

public class isBalancedMainClass {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new isBalancedMainClassSolution().isBalanced(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}