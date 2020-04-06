package com.leetcode.DataStructure.cache.LFU2;

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
