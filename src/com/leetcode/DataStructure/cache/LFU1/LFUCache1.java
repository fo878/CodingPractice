package com.leetcode.DataStructure.cache.LFU1;
/*
*实现LFU缓存
* */

/*
* 方法一 O(logN)：使用小根堆找到freq最小的
* */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class LFUCache1 {

    Map<Integer, Node> cache;
    Queue<Node> queue;
    int capacity;
    int size;
    int idx = 0;

    public LFUCache1(int capacity) {
        cache = new HashMap<>(capacity);
        if (capacity > 0) {
            queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        node.idx = idx++;
        queue.remove(node);
        queue.offer(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.freq++;
            node.idx = idx++;
            queue.remove(node);
            queue.offer(node);
        } else {
            if (size == capacity) {
                cache.remove(queue.peek().key);
                queue.poll();
                size--;
            }
            Node newNode = new Node(key, value, idx++);
            cache.put(key, newNode);
            queue.offer(newNode);
            size++;
        }
    }
}

