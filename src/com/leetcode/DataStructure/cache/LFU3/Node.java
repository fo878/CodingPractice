package com.leetcode.DataStructure.cache.LFU3;

class Node {

    int key;
    int value;
    int freq = 1;
    Node pre; // Node所在频次的双向链表的前继Node
    Node post; // Node所在频次的双向链表的后继Node
    DoublyLinkedList doublyLinkedList;  // Node所在频次的双向链表

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
