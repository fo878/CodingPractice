package com.leetcode.DataStructure.Tree;

public class HasSubtree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    *
    * root2是root1的一个结点（node）
    * root2的左子树与node的左子树相等
    * root2的右子树于node的右子树相等
    * */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val == root2.val){
            return HasSubtree(root1.left,root2.left) && HasSubtree(root1.right,root2.right);
        }else {
            TreeNode rootLeft = root1.left;
            TreeNode rootRight = root1.right;
            return HasSubtree(rootLeft,root2) || HasSubtree(rootRight,root2);
        }
    }
}
