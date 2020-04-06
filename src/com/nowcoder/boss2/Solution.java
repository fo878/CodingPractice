package com.nowcoder.boss2;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
public class Solution {
    /**
     * 返回树的高度
     * @param root TreeNode类 树根节点
     * @return int整型
     */
    public int getTreeHeight (TreeNode root) {
        // write code here
        if (root == null){
            return 0;
        }else {
            int left_h = getTreeHeight(root.left);
            int right_h = getTreeHeight(root.right);
            return Math.max(left_h,right_h) + 1;
        }
    }
}