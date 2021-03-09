package com.leetcode.DataStructure.array;

import java.util.Arrays;

/*
* 724. 寻找数组的中心索引
*
给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
* */
public class pivotIndexSolution {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] preSum = new int[n];//前缀和数组，preSume[i]保存nums[0]...num[i-1]的和
        preSum[0] = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if (i > 0) {
                preSum[i] = preSum[i-1] + nums[i-1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (sum-nums[i] == 2 * preSum[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,7,3,6,5,6
        };
        pivotIndexSolution foo = new pivotIndexSolution();
        System.out.println(foo.pivotIndex(nums));
    }
}
