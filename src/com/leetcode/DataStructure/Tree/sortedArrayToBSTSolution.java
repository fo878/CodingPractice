package com.leetcode.DataStructure.Tree;
/*
* 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
* */


import java.util.Arrays;

public class sortedArrayToBSTSolution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        TreeNode root_cur = root;
        for (int i = 1; i < nums.length; i++) {
            if (root_cur.left == null){
                root_cur.left = new TreeNode(nums[i]);
            }else if (root_cur.right == null){
                root_cur.right = new TreeNode(nums[i]);
                root_cur = root_cur.left;
            }
        }
        return root;
    }

    /*
    * 答案
    * */
    public TreeNode sortedArrayToBST1(int[] nums) {

        if (nums.length == 0)
            return null;

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return root;
    }

}
