package com.offer.test;

import java.util.Stack;

/*
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
* 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
* 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
* （注意：这两个序列的长度是相等的）
*
* 分析：
*
* */
public class IsPopOrderSolution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        Stack<Integer> s = new Stack<Integer>();

        for(int i=0, j=0;  i < len; i++){
            s.push(pushA[i]);//把第一个数组中的数循环进栈
            while(j < len && s.peek() == popA[j]){
                //当栈顶元素与第二个数组的第j个元素相同时出栈
                s.pop();
                j = j+1;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {

    }
}
