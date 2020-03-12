package com.leetcode.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
* 要求不能创建任何新的节点，只能调整树中节点指针的指向。
*
* 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
* 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
* 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
* 树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
* */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class treeToDoublyListSolution {
    /*-----------------递归-------------------------*/
    /*
    * 改写中序遍历，遍历过程中使用一全局变脸pre存储其前一个结点,当遍历该结点时，
    * 只需该节点的前驱(left)指向pre，pre的后继指向该节点。对于头结点应特殊处理。
    * */
    public Node pre;
    public Node head, tail;
    public void process(Node root){
        if(root == null)   return;
        process(root.left);
        root.left = pre;
        if(pre == null){
            head = root;
        }else{
            pre.right = root;
        }
        pre = root;
        tail = root;
        process(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        process(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    /*-----------------非递归-------------------------*/
    public Node treeToDoublyList1(Node root) {
        if(root == null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node pre = null, head = null, tail = null;
        while(!stack.isEmpty() || current != null) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            tail = current;
            if(pre == null) {//处理头结点
                head = current;
            }else {
                pre.right = current;
                current.left = pre;
            }
            pre = current;
            current = current.right;
        }
        tail.right = head;
        head.left = tail;
        return head;
    }
}
