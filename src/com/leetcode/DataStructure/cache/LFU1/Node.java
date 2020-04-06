package com.leetcode.DataStructure.cache.LFU1;

class Node implements Comparable<Node> {
    int key;
    int value;
    int freq;
    int idx;

    public Node() {}

    public Node(int key, int value, int idx) {
        this.key = key;
        this.value = value;
        freq = 1;
        this.idx = idx;
    }

    public int compareTo(Node node) {
        int diff = freq - node.freq;
        return diff != 0? diff: idx - node.idx;
    }
}
