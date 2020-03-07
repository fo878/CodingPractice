package com.offer.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
* 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
* 若队列为空，pop_front 和 max_value 需要返回 -1

* */
class MaxQueue {

    Deque<Integer> queue = null;
    int max = Integer.MIN_VALUE;
    public MaxQueue() {
        queue = new ArrayDeque<Integer>();
    }

    public int max_value() {
        if (queue.isEmpty()){
            return -1;
        }else return max;
    }

    public void push_back(int value) {
        queue.add(value);
        if (value>max){
            max = value;
        }
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }else {
            Integer poll = queue.pollFirst();
            if (poll == max){
                Object[] a = queue.toArray();
                int preMax = Integer.MIN_VALUE;
                for (int i = 0; i < a.length; i++) {
                    if ((int)a[i]>preMax){
                        preMax = (int)a[i];
                    }
                }
                max = preMax;
            }
            return poll;
        }
    }
}