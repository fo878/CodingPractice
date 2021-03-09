package com.leetcode.DataStructure.expend;

import java.util.Arrays;

class NumArray {

    private int[] A;
    int sum;

    public NumArray(int[] nums) {
        this.A = nums.clone();
        this.sum = 0;
    }
    
    public int sumRange(int i, int j) {
        sum = 0;
        for (int k = i; k < j+1; k++) {
            sum += A[k];
        }
        return sum;
    }
}
class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
         NumArray obj = new NumArray(nums);
         int param_1 = obj.sumRange(0,2);//1
         int param_2 = obj.sumRange(2,5);//-1
         int param_3 = obj.sumRange(0,5);//-3
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}