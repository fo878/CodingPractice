package com.leetcode.DataStructure.list;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*
* 根据next指针遍历每一个原链表元素，借助辅助map，获得每个元素的复制元素，
* 修改复制元素的next、random指针，返回原链表head的复制元素。
*
* 分析：
*   根据next指针遍历每一个原链表元素，借助辅助map，获得每个元素的复制元素，修改复制元素的next、random指针，
*   返回原链表head的复制元素。
* */
public class copyRandomList {
    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while(ptr != null) {
            Node node = getNode(ptr);
            node.next = getNode(ptr.next);
            node.random = getNode(ptr.random);
            ptr = ptr.next;
        }
        return getNode(head);
    }

    private Node getNode(Node node) {
        if (node == null) return null;
        if (!map.containsKey(node)) {
            Node tmp = new Node(node.val);
            map.put(node, tmp);
        }
        return map.get(node);
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
//官方答案
class copyRandomListSolution2 {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
