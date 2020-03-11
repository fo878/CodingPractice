package com.leetcode.DataStructure.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

* */
class lowestCommonAncestorSolution {
    /*
    递归法
    从根节点开始遍历树
    如果节点 p 和节点 q 都在右子树上，那么以右孩子为根节点继续 1 的操作
    如果节点 p 和节点 q 都在左子树上，那么以左孩子为根节点继续 1 的操作
    如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 p 和节点 q 的 LCA 了
    * */
    public TreeNode lowestCommonAncestor1(TreeNode root, int p, int q) {
        int prentVal = root.val;
        int p_val = p;
        int q_val = q;
        if (p > prentVal && q > prentVal)   return lowestCommonAncestor1(root.right,p,q);
        else if (p < prentVal && q < prentVal)   return lowestCommonAncestor1(root.left,p,q);
        else {
            System.out.println(root.val);
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int p_val = p.val;
        int q_val = q.val;
        TreeNode node = root;
        while(node != null){
            int prentVal = root.val;
            if (p.val > prentVal && q.val > prentVal){
                node = node.right;
            }else if (p.val < prentVal && q.val < prentVal){
                node = node.left;
            }else return node;
        }
        return null;
    }
}

public class lowestCommonAncestorMainClass {
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

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int p = Integer.parseInt(line);
            line = in.readLine();
            int q = Integer.parseInt(line);

            //对原模板进行了更改，p，q改为int类型，避免报错
            TreeNode ret = new lowestCommonAncestorSolution().lowestCommonAncestor1(root, p, q);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}