package com.leetcode.DataStructure.array;

import java.util.Stack;

/*
* 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
* 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
*
*       输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        输出：true
        解释：我们可以按以下顺序执行：
        push(1), push(2), push(3), push(4), pop() -> 4,
        push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
* */
public class validateStackSequencesSolution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) return false;
        int N = pushed.length;
        int j = 0;
        Stack<Integer> stack = new Stack();
        for(int x : pushed){
            stack.push(x);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j==N;
    }
}
