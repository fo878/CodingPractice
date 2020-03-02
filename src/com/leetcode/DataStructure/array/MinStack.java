package com.leetcode.DataStructure.array;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s = new Stack<>();
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        Stack<Object> obj = new Stack<>();
    }

    public void push(int x) {

        if(min > x || s.isEmpty()){
            min = x;
        }
        s.push(x);
    }

    public void pop() {
        if(s.isEmpty()){
            System.out.println("栈已空");
        }else{
            int i = s.pop();
            if(min == i && s.isEmpty()==false) {
                min = s.get(0);
                for (Integer integer : s) {
                    if (integer < min){
                        min = integer;
                    }
                }
            }
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */