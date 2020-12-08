package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
*该类下，通过递归来解决树的问题
* 比如：树的最大深度、对称二叉树、路径总和
* */
public class Recursion {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 求树的最大深度
     * */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }


    /*
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 递归方法分析
     *   该问题可以转化为：两个树在什么情况下互为镜像？
     *   如果同时满足下面的条件，两个树互为镜像：
     *       1.它们的两个根结点具有相同的值。
     *       2.每个树的右子树都与另一个树的左子树镜像对称。
     *
     *
     * */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && (isMirror(t1.left, t2.right)) && (isMirror(t1.right, t2.left));
    }

    /*
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 迭代方法分析：
     * */

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    /*
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和。
     *
     * 分析：
     *  声明一个变量记录已经经过的节点的值之和，每经过一个节点就加上这个节点的值，在叶子节点判断变量值是否为目标值
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            return sum-root.val==0;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

}
