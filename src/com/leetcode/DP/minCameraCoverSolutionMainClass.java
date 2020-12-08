package com.leetcode.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 968. 监控二叉树  hard
*
给定一个二叉树，我们在树的节点上安装摄像头。
节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
计算监控树的所有节点所需的最小摄像头数量。
*
有三个状态:
0=>这个结点待覆盖
1=>这个结点已经覆盖
2=>这个结点上安装了相机
* */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class minCameraCoverSolution {

    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (lrd(root)==0){
            res++;
        }
        return res;
    }

    private int lrd(TreeNode node) {
        if (node==null){
            return 1;//这个结点已经覆盖
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        if (left==0 || right==0){
            //左或右是待覆盖,该节点已安装相机
            res += 1;
            return 2;
        }
        if (left==1 && right==1){
            //左右都已覆盖，但是都没安装相机，所以node是待覆盖的
            return 0;
        }

        if (left + right >= 3){
            //左、右至少有一个装相机了
            return 1;
        }
        return -1;
    }
}

public class minCameraCoverSolutionMainClass {
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

            int ret = new minCameraCoverSolution().minCameraCover(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
