package com.leetcode.DataStructure.array.window;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 703. 数据流中的第 K 大元素
*
* 设计一个找到数据流中第 k 大元素的类（class）。
* 注意是排序后的第 k 大元素，不是第 k 个不同的元素。
请实现 KthLargest 类：
KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
* */
class KthLargest {

    int k;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}