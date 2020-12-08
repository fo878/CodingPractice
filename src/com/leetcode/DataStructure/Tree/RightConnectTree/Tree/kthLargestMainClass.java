package com.leetcode.DataStructure.Tree.RightConnectTree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 二叉搜索树的第k大节点
* 答案1出处
* https://yanghang.blog.csdn.net/article/details/104437722
* */
class CSDNSolution {
    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }
}

/*
* 中序遍历后输出第n-k的值，时间复杂度较高
* */
class kthLargestSolution {
    public int kthLargest(TreeNode root, int k) {
        List list = inorderTraversal(root);
        return (int)list.get(list.size()-k);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null){
            return output;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            output.add(cur.val);
            cur = cur.right;
        }

        return output;
    }
}

public class kthLargestMainClass {
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
            line = in.readLine();
            int k = Integer.parseInt(line);

            int ret = new kthLargestSolution().kthLargest(root, k);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}