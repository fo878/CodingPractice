package com.leetcode.DataStructure.array;

import java.util.Arrays;
import java.util.Collections;

class NumArray {

    int[] numArray;
    public NumArray(int[] nums) {
        numArray = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            numArray[i] = nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        int n = j-i+1;
        int[] subArray = new int[n];
        subArray = Arrays.copyOfRange(numArray,i,j+1);
        int sum = 0;
        for (int num : subArray) {
            sum += num;
        }
        return sum;
    }
}