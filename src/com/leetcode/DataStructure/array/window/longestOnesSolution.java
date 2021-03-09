package com.leetcode.DataStructure.array.window;
/*
1004. 最大连续1的个数 III
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度。

对于区间[left,right]而言，只要它包含不超过K个0，我们就可以构造出一组满足要求，并且长度为right-left+1的区间

所以将问题转化为
1. 对于任意的右端点right,希望找到最小的左端点left,使得[left,right]包含不超过K个0
2. 枚举所有可能的右端点，将得到的区间长度取最大值，即可得到答案


* */
class longestOnesSolution {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rightSum += 1 - A[right];
            while (leftSum < rightSum - K){
                leftSum += 1 - A[left];
                left += 1;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans;
    }
}