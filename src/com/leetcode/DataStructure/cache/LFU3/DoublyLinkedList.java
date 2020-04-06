package com.leetcode.DataStructure.cache.LFU3;

class DoublyLinkedList {

    int freq; // 该双向链表表示的频次

    DoublyLinkedList pre;  // 该双向链表的前继链表（pre.freq < this.freq）

    DoublyLinkedList post; // 该双向链表的后继链表 (post.freq > this.freq)

    Node head; // 该双向链表的头节点，新节点从头部加入，表示最近访问

    Node tail; // 该双向链表的尾节点，删除节点从尾部删除，表示最久访问


    public DoublyLinkedList() {

        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;

    }


    public DoublyLinkedList(int freq) {

        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
        this.freq = freq;

    }


    void removeNode(Node node) {

        node.pre.post = node.post;

        node.post.pre = node.pre;

    }


    void addNode(Node node) {

        node.post = head.post;

        head.post.pre = node;

        head.post = node;

        node.pre = head;

        node.doublyLinkedList = this;

    }
}
