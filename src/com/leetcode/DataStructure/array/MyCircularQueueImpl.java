package com.leetcode.DataStructure.array;

public class MyCircularQueueImpl {

    /*
    * 成员变量
    * 头head、尾tail、大小size、数据Data
    * */
    private int[] data;
    private int head;
    private int tail;
    private int size;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueueImpl(int k) {
        data = new int[k];
        size = k;
        head = -1;
        tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }else {
            tail = (tail + 1) % size;
            data[tail] = value;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (head == -1){
            return true;
        }else{
            return false;
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((tail+1)%size==head){
            return true;
        }else {
            return false;
        }
    }
}
