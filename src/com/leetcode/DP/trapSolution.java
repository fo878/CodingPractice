package com.leetcode.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;
/*
* 42. 接雨水
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* */
public class trapSolution {
    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1){
            return 0;
        }
        int L_Max,R_Max,cur,res=0;
        int[] dp = new int[height.length];
        LinkedList<Integer> leftList = new LinkedList<Integer>();
        LinkedList<Integer> rightList = new LinkedList<Integer>();
        leftList.add(height[0]);
        L_Max = height[0];
        for (int i = 1; i < height.length; i++) {
            rightList.add(height[i]);
        }
        R_Max = Collections.max(rightList);
        dp[0] = 0;
        dp[dp.length-1] = 0;
        for (int i = 1; i < dp.length-1; i++) {
            cur = rightList.poll();
            if (cur == R_Max){
                R_Max = Collections.max(rightList);
            }
            if (Math.min(L_Max,R_Max)-cur > 0){
                dp[i] = Math.min(L_Max,R_Max)-cur;
            }else dp[i] = 0;
            leftList.add(cur);
            if (cur > L_Max){
                L_Max = cur;
            }
            res += dp[i];
        }
        return res;
    }

/*  作者：sweetiee
    链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
    来源：力扣（LeetCode）
    单调栈的方法
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int trap1(int[] height) {
            if (height == null) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int curIdx = stack.pop();
                    // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                    while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        int stackTop = stack.peek();
                        // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                        // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                        // i - stackTop - 1 是雨水的宽度。
                        ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                    }
                }
                stack.add(i);
            }
            return ans;
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] strings = line.trim().split(",");
        int[] height = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            height[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(trap(height));
    }
}
