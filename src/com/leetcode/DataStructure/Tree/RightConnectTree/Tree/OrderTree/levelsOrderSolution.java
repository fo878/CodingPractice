package com.leetcode.DataStructure.Tree.RightConnectTree.Tree.OrderTree;
//从上到下打印二叉树
/*
* 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
* 二叉树的层次遍历
*
* 广度优先搜索BFS，使用优先队列
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelsOrderSolution {
    /*算法流程：
    特例处理： 当树的根节点为空，则直接返回空列表 [] ；
    初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
    BFS 循环： 当队列 queue 为空时跳出；
    出队： 队首元素出队，记为 node；
    打印： 将 node.val 添加至列表 tmp 尾部；
    添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
    返回值： 返回打印结果列表 res 即可。

*/
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
