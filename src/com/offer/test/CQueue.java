package com.offer.test;

import java.util.LinkedList;
import java.util.Stack;

/*
* 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
* 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
* */
class CQueue {

    Stack stack1 = null;
    Stack stack2 = null;
    int size = 0;
    public CQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
        size = 0;
    }
    
    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }
    
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return (int)stack1.pop();
    }
}

class CQueue1 {
    LinkedList<Integer> A, B;
    public CQueue1() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
