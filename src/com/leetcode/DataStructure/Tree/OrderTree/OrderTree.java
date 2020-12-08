package com.leetcode.DataStructure.Tree.OrderTree;

import java.util.*;

public class OrderTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /*
    * 二叉树的前序遍历
    * */
    public List<Integer> preorderTraversal (TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            //LinkedList.pollLast()方法检索并删除最后一个（最高）元素，如果此集合为空，则返回 null
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    /*
     * 二叉树的中序序遍历
     * */

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

    /*
    * 二叉树的后序遍历
    * */

    /*
    * 1先判断当前结点是不是null，是的话直接输出结果
    * 2当前节点进栈
    * 3判断左结点是否存在
    *   存在
    *       4左结点进栈，左结点设为当前结点返回1
    *   不存在
    *       5右结点是否存在
    *           存在
    *               右结点进栈，右结点设为当前结点返回1
    *           不存在
    *               6栈不为空时，当前结点出栈保存
    * */
//    public List<Integer> postorderTraversal1(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        LinkedList<Integer> output = new LinkedList<>();
//        if (root == null){
//            return output;
//        }
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null){
//            stack.push(cur);
//            if (cur.left != null){
//                cur = cur.left;
//            }else if(cur.right !=null){
//                cur = cur.right;
//            }else {
//                output.add(stack.pop().val);
//                cur = stack.peek();
//                /*
//                * 错误！！！
//                * 原因是这里虽然把指针指向了父结点，但是子节点依然存在
//                * */
//            }
//        }
//        return output;
//    }

    /*
     * 二叉树后序遍历
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            output.addFirst(node.val);
        }
        return output;
    }

    /*
    * 二叉树的广度优先遍历，层次遍历
    * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    * */
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void help(TreeNode node,int level){

        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
            levels.get(level).add(node.val);
        if (node.left != null){
            help(node.left,level + 1);
        }
        if (node.right != null){
            help(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return levels;
        }
        help(root,0);
        return levels;
    }

    /*
    * 二叉树层次遍历（迭代方法）
    *
    * 初始化队列只包含一个节点 root 和层次编号 0 ： level = 0。
    * 当队列非空的时候：
    *   在输出结果 levels 中插入一个空列表，开始当前层的算法。
    *   计算当前层有多少个元素：等于队列的长度。
    *   将这些元素从队列中弹出，并加入 levels 当前层的空列表中。
    *   将他们的孩子节点作为下一层压入队列中。
    *   进入下一层 level++。
    * */

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<List<Integer>>();
            if (root == null) return levels;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while ( !queue.isEmpty() ) {
                // start the current level
                levels.add(new ArrayList<Integer>());

                // number of elements in the current level
                int level_length = queue.size();
                for(int i = 0; i < level_length; ++i) {
                    TreeNode node = queue.remove();

                    // fulfill the current level
                    levels.get(level).add(node.val);

                    // add child nodes of the current level
                    // in the queue for the next level
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                // go to next level
                level++;
            }
            return levels;
        }
    }
}
