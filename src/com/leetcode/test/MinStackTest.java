package com.leetcode.test;

import com.leetcode.DataStructure.array.MinStack;
/*
* ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
*
* */


public class MinStackTest {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());

//        int param_3 = obj.top();
//        int param_4 = obj.getMin();
//        System.out.println("栈顶元素为："+ param_3 );
//        System.out.println("最小值为："+ param_4 );
    }
}
