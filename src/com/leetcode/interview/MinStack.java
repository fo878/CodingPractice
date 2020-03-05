package com.leetcode.interview;

import java.util.Stack;

class MinStack {

    Stack stack = null;
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if(x<min){
            min = x;
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            int p = (int)stack.pop();
            if (p==min){
                int newmin = Integer.MAX_VALUE;
                for (Object s : stack) {
                    if ((int)s<newmin){
                        newmin = (int)s;
                    }
                }
                min = newmin;
            }
        }
    }
    
    public int top() {
        return (int)stack.peek();
    }
    
    public int min() {
        return min;
    }
}