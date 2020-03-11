package com.leetcode.DataStructure.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
* 二叉树的直径
* 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
*
*
* 分析：
*   二叉树的直径 = MAX（左子树的直径，右子树的直径，左子树深度+右子树深度）
* */

class diameterOfBinaryTreeSolution {
    public int diameterOfBinaryTree(TreeNode root) {

        //递归求解，复杂度高，可以用dfs优化
        if (root == null){
            return 0;
        }else if (root.left == null){
            return Math.max(diameterOfBinaryTree(root.right),maxDepth(root.right));
        }else if (root.right == null){
            return Math.max(diameterOfBinaryTree(root.left),maxDepth(root.left));
        }else {
            return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)),maxDepth(root.left)+maxDepth(root.right));
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }


}
public class diameterOfBinaryTreeMainClass {
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

            int ret = new diameterOfBinaryTreeSolution().diameterOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}